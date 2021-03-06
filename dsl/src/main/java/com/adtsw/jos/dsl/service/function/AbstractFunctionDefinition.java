package com.adtsw.jos.dsl.service.function;

import com.adtsw.jos.dsl.model.contexts.ArgumentContext;
import com.adtsw.jos.dsl.model.contexts.FunctionContext;
import com.adtsw.jos.dsl.model.contexts.ScriptLineContext;
import com.adtsw.jos.dsl.model.contexts.ScriptRuntimeContext;

import java.util.Objects;

public abstract class AbstractFunctionDefinition {

    public abstract void execute(ScriptLineContext scriptLineContext, ScriptRuntimeContext runtimeContext);

    protected Object getArgValue(FunctionContext functionContext, ScriptRuntimeContext runtimeContext, int i) {
        ArgumentContext argContext = functionContext.getOriginalArgs()[i];
        Object argObject = argContext.getLexemes()[0];
        return getObject(runtimeContext, argObject);
    }

    protected Object getObject(ScriptRuntimeContext runtimeContext, Object input) {
        if(input instanceof String) {
            Object runtimeVariable = runtimeContext.getVariableValue((String) input);
            if(runtimeVariable != null) {
                input = runtimeVariable;
            }
        }
        return input;
    }

    protected Object[] replaceRuntimeVariables(ScriptRuntimeContext runtimeContext, Object[] originalLexemes) {

        Object[] compiledLexemes = new Object[originalLexemes.length];
        for (int i = 0; i < originalLexemes.length; i++) {
            Object lexeme = originalLexemes[i];
            if(lexeme instanceof String) {
                Object computedVariableValue = runtimeContext.getVariableValue((String) lexeme);
                compiledLexemes[i] = Objects.requireNonNullElse(computedVariableValue, lexeme);
            } else {
                compiledLexemes[i] = lexeme;
            }
        }
        return compiledLexemes;
    }
}

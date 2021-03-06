package com.adtsw.jos.dsl.service.function;

import com.adtsw.jos.dsl.model.contexts.ScriptLineContext;
import com.adtsw.jos.dsl.model.contexts.ScriptRuntimeContext;
import com.adtsw.jos.dsl.utils.ExpressionEvaluator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SetExpressionValueFunction extends AbstractFunctionDefinition {

    @Override
    public void execute(ScriptLineContext lineContext, ScriptRuntimeContext runtimeContext) {
        String objectName = lineContext.getVariableContext().getName();
        Object[] originalLexemes = lineContext.getFunctionContext().getOriginalArgs()[0].getLexemes();
        Object[] compiledLexemes = replaceRuntimeVariables(runtimeContext, originalLexemes);
        Object evaluationResult = (new ExpressionEvaluator()).evaluate(compiledLexemes);
        runtimeContext.setVariableValue(objectName, evaluationResult);
    }
}

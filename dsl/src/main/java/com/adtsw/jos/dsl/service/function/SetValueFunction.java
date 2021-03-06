package com.adtsw.jos.dsl.service.function;

import com.adtsw.jos.dsl.model.contexts.ScriptLineContext;
import com.adtsw.jos.dsl.model.contexts.ScriptRuntimeContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SetValueFunction extends AbstractFunctionDefinition {

    @Override
    public void execute(ScriptLineContext lineContext, ScriptRuntimeContext runtimeContext) {
        String objectName = lineContext.getVariableContext().getName();
        Object objectValue = lineContext.getFunctionContext().getOriginalArgs()[0].getLexemes()[0];
        objectValue = getObject(runtimeContext, objectValue);
        runtimeContext.setVariableValue(objectName, objectValue);
    }
}

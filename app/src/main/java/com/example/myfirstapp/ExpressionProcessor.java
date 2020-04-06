package com.example.myfirstapp;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

class ExpressionProcessor {
    private Log log;

    ExpressionProcessor(Log log) {
        this.log = log;
    }

    String run(String expression) {
        String result;
        try {
            result = tryRun(expression);
        } catch (Exception e) {
            log.d(this.getClass().getSimpleName(), e.toString());
            result = "Invalid expression";
        }
        return result;
    }

    private String tryRun(String expression) {
        Context context = getScriptingContext();
        Scriptable scope = context.initStandardObjects();
        Object resultObject = context.evaluateString(scope, expression, "<cmd>", 1, null);
        return resultObject.toString();
    }

    private Context getScriptingContext() {
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        return context;
    }
}

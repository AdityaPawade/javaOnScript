// basic if conditions

test_variable = 14;
test_variable_copy_expression = 28;

test_v = test_function(param_a: 222, param_b: test_variable, param_c: "string_variable");

if(test_variable_copy_expression != null && 
    test_variable != 2) {
    log("test variable");
    log(test_variable);
}

incremental_variable = 0;
if((test_variable_copy_expression >= test_variable && test_variable == 14) && test_variable_copy_expression >= test_variable) {
    incremental_variable = incremental_variable + 1;
}

if(test_variable_copy_expression < test_variable) {
    incremental_variable = incremental_variable - 1;
}

log("incremental variable");
log(incremental_variable);
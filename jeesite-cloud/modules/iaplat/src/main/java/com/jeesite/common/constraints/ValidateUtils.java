package com.jeesite.common.constraints;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;



public class ValidateUtils
{
    public static List<Violation> validate(Object entity) {
        List<Violation> violations = Lists.newArrayList();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> constraints = validator.validate(entity, new Class[0]);
        if (constraints.size() > 0) {
            Violation violation = null;
            for (ConstraintViolation<Object> constraint : constraints) {
                violation = new Violation();
                String property = constraint.getPropertyPath().toString();
                String message = constraint.getMessage();
                violation.setProperty(property);
                violation.setMessage(message);
                violations.add(violation);
            }
        }
        return violations;
    }
}

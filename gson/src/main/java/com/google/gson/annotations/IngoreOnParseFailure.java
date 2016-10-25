package com.google.gson.annotations;/*
 * This file is part of gson-parent.
 * 
 * Created by christophesmet on 25/10/2016
 * 
 * (c) 2016 November Five BVBA
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import java.lang.annotation.*;

/**
 * An annotiation that indicates this member will be parsed as null when the field is invalid or a parse error happens.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IngoreOnParseFailure {
}

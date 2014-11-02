import org.codenarc.rule.basic.EmptyMethodRule

ruleset {

    ruleset('rulesets/basic.xml') {
        include 'AssertWithinFinallyBlock'
        include 'AssignmentInConditional'
        include 'BigDecimalInstantiation'
        include 'BitwiseOperatorInConditional'
        include 'BooleanGetBoolean'
        include 'BrokenNullCheck'
        include 'BrokenOddnessCheck'
        include 'ClassForName'
        include 'ComparisonOfTwoConstants'
        include 'ComparisonWithSelf'
        include 'ConstantAssertExpression'
        include 'ConstantTernaryExpression'
        include 'ConstantIfExpression'
        include 'DeadCode'
        include 'DoubleNegative'
        include 'DuplicateCaseStatement'
        include 'DuplicateMapKey'
        include 'DuplicateSetValue'
        include 'EmptyCatchBlock'
        include 'EmptyClass'
        include 'EmptyElseBlock'
        include 'EmptyFinallyBlock'
        include 'EmptyForStatement'
        include 'EmptyIfStatement'
        include 'EmptySwitchStatement'
        include 'EmptySynchronizedStatement'
        include 'EmptyStaticInitializer'
        include 'EmptyWhileStatement'
        include 'EmptyInstanceInitializer'
    }

    ruleset('rulesets/grails.xml') {
        include 'GrailsDuplicateMapping'
        include 'GrailsPublicControllerMethod'
        include 'GrailsServletContextReference'
        include 'GrailsSessionReference'
        include 'GrailsStatelessService'
        include 'GrailsDuplicateConstraint'
        include 'GrailsDomainWithServiceReference'
        include 'GrailsDomainReservedSqlKeywordName'
    }

    ruleset('rulesets/imports.xml') {
        include 'DuplicateImport'
        include 'ImportFromSamePackage'
        include 'UnnecessaryGroovyImport'
        include 'UnusedImport'
        include 'ImportFromSunPackages'
        include 'MisorderedStaticImports'
        include 'NoWildcardImports'
    }
}
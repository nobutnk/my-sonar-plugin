package com.nobutnk.sonar.plugin;

import java.util.List;

import org.sonar.api.internal.google.common.collect.ImmutableList;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

@Rule(key = "MyFirstCustomRule")
public class MethodInvocationCustomCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Kind> nodesToVisit() {
        return ImmutableList.of(Kind.METHOD_INVOCATION);
    }

    @Override
    public void visitNode(Tree tree) {
//        MethodTree method = (MethodTree) tree;
//        if (method.parameters().size() == 1) {
//          MethodSymbol symbol = method.symbol();
//          Type firstParameterType = symbol.parameterTypes().get(0);
//          Type returnType = symbol.returnType().type();
//          if (returnType.is(firstParameterType.fullyQualifiedName())) {
//            reportIssue(method.simpleName(), "Never do that!");
//          }
//        }
        if (tree.is(Tree.Kind.METHOD_INVOCATION)) {

            MethodInvocationTree mit = (MethodInvocationTree) tree;
            String mname = mit.symbol().name();
            System.out.println("Invoked Method  " + mname);
        }
    }
}

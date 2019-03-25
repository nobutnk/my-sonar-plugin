package com.nobutnk.sonar.plugin;

import java.util.List;

import org.sonar.api.internal.google.common.collect.ImmutableList;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.Arguments;
import org.sonar.plugins.java.api.tree.ExpressionTree;
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
        MethodInvocationTree methodTree = (MethodInvocationTree) tree;
        Arguments params = methodTree.arguments();
        String methodName = methodTree.symbol().name();
        if (methodName.startsWith("set") && params.size() == 1) {
            ExpressionTree et = params.get(0);
            Type type = et.symbolType();
            if (type.isSubtypeOf("java.util.Collection")) {
                reportIssue(et, "\"setter\" method parameters is Collection");
            }
        }
    }
}

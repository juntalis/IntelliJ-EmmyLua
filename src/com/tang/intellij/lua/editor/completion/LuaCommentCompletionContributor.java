package com.tang.intellij.lua.editor.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import com.tang.intellij.lua.doc.psi.LuaDocTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

/**
 *
 * Created by tangzx on 2016/12/2.
 */
public class LuaCommentCompletionContributor extends CompletionContributor {

    public LuaCommentCompletionContributor() {
        extend(CompletionType.BASIC, psiElement().afterLeaf("@"), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
                String[] keyWords = new String[]{ "class", "param", "return" };
                for (String keyWord : keyWords) {
                    completionResultSet.addElement(LookupElementBuilder.create(keyWord));
                }
            }
        });

        extend(CompletionType.BASIC, psiElement().afterLeaf(psiElement().withElementType(LuaDocTypes.PARAM_NAME_REF)), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
                completionResultSet.addElement(LookupElementBuilder.create("sss"));
            }
        });
    }

}

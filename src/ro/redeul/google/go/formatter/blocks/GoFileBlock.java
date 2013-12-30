package ro.redeul.google.go.formatter.blocks;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static ro.redeul.google.go.formatter.blocks.GoFormatterUtil.*;

/**
 * @author Mihai Claudiu Toader <mtoader@gmail.com>
 *         Date: 6/3/12
 */
class GoFileBlock extends GoBlock {
    private static final TokenSet NEED_NEW_LINE_TOKENS = TokenSet.create(
        PACKAGE_DECLARATION,
        IMPORT_DECLARATIONS,
        CONST_DECLARATIONS,
        VAR_DECLARATIONS,
        TYPE_DECLARATIONS,
        FUNCTION_DECLARATION,
        METHOD_DECLARATION,
        mSL_COMMENT,
        mML_COMMENT
    );

    public GoFileBlock(ASTNode node, Alignment alignment, Indent indent,
                       Wrap wrap, CommonCodeStyleSettings settings) {
        super(node, alignment, indent, wrap, settings);
    }

    // nothing should be indented on the top level of file
    @Override
    protected TokenSet getIndentedElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {

        IElementType typeChild1 = getASTElementType(child1);
        IElementType typeChild2 = getASTElementType(child2);

        if (NEED_NEW_LINE_TOKENS.contains(typeChild1)) {
            if (typeChild1 != typeChild2)
                return LINE_SPACING;

            return getLineCount(getTextBetween(child1, child2)) > 1
                        ? LINE_SPACING : ONE_LINE_SPACING;
        }

        return null;
    }
}

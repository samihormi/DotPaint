/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AMarkpoint extends PMarkpoint
{
    private TKeywordmark _keywordmark_;

    public AMarkpoint()
    {
        // Constructor
    }

    public AMarkpoint(
        @SuppressWarnings("hiding") TKeywordmark _keywordmark_)
    {
        // Constructor
        setKeywordmark(_keywordmark_);

    }

    @Override
    public Object clone()
    {
        return new AMarkpoint(
            cloneNode(this._keywordmark_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMarkpoint(this);
    }

    public TKeywordmark getKeywordmark()
    {
        return this._keywordmark_;
    }

    public void setKeywordmark(TKeywordmark node)
    {
        if(this._keywordmark_ != null)
        {
            this._keywordmark_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordmark_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._keywordmark_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordmark_ == child)
        {
            this._keywordmark_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._keywordmark_ == oldChild)
        {
            setKeywordmark((TKeywordmark) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
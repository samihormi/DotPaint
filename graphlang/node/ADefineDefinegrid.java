/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class ADefineDefinegrid extends PDefinegrid
{
    private TKeywordmake _keywordmake_;
    private TNumber _number_;

    public ADefineDefinegrid()
    {
        // Constructor
    }

    public ADefineDefinegrid(
        @SuppressWarnings("hiding") TKeywordmake _keywordmake_,
        @SuppressWarnings("hiding") TNumber _number_)
    {
        // Constructor
        setKeywordmake(_keywordmake_);

        setNumber(_number_);

    }

    @Override
    public Object clone()
    {
        return new ADefineDefinegrid(
            cloneNode(this._keywordmake_),
            cloneNode(this._number_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefineDefinegrid(this);
    }

    public TKeywordmake getKeywordmake()
    {
        return this._keywordmake_;
    }

    public void setKeywordmake(TKeywordmake node)
    {
        if(this._keywordmake_ != null)
        {
            this._keywordmake_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordmake_ = node;
    }

    public TNumber getNumber()
    {
        return this._number_;
    }

    public void setNumber(TNumber node)
    {
        if(this._number_ != null)
        {
            this._number_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._number_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._keywordmake_)
            + toString(this._number_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordmake_ == child)
        {
            this._keywordmake_ = null;
            return;
        }

        if(this._number_ == child)
        {
            this._number_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._keywordmake_ == oldChild)
        {
            setKeywordmake((TKeywordmake) newChild);
            return;
        }

        if(this._number_ == oldChild)
        {
            setNumber((TNumber) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AStmtStmtlist extends PStmtlist
{
    private PStmt _stmt_;

    public AStmtStmtlist()
    {
        // Constructor
    }

    public AStmtStmtlist(
        @SuppressWarnings("hiding") PStmt _stmt_)
    {
        // Constructor
        setStmt(_stmt_);

    }

    @Override
    public Object clone()
    {
        return new AStmtStmtlist(
            cloneNode(this._stmt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStmtStmtlist(this);
    }

    public PStmt getStmt()
    {
        return this._stmt_;
    }

    public void setStmt(PStmt node)
    {
        if(this._stmt_ != null)
        {
            this._stmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._stmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._stmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._stmt_ == child)
        {
            this._stmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._stmt_ == oldChild)
        {
            setStmt((PStmt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

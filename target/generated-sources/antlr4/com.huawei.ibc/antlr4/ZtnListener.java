// Generated from com.huawei.ibc\antlr4\Ztn.g4 by ANTLR 4.7.1
package com.huawei.ibc.antlr4;

    import java.util.*;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZtnParser}.
 */
public interface ZtnListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZtnParser#zn}.
	 * @param ctx the parse tree
	 */
	void enterZn(ZtnParser.ZnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#zn}.
	 * @param ctx the parse tree
	 */
	void exitZn(ZtnParser.ZnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#showCommand}.
	 * @param ctx the parse tree
	 */
	void enterShowCommand(ZtnParser.ShowCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#showCommand}.
	 * @param ctx the parse tree
	 */
	void exitShowCommand(ZtnParser.ShowCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#newCommand}.
	 * @param ctx the parse tree
	 */
	void enterNewCommand(ZtnParser.NewCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#newCommand}.
	 * @param ctx the parse tree
	 */
	void exitNewCommand(ZtnParser.NewCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#delCommand}.
	 * @param ctx the parse tree
	 */
	void enterDelCommand(ZtnParser.DelCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#delCommand}.
	 * @param ctx the parse tree
	 */
	void exitDelCommand(ZtnParser.DelCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#findPathCommand}.
	 * @param ctx the parse tree
	 */
	void enterFindPathCommand(ZtnParser.FindPathCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#findPathCommand}.
	 * @param ctx the parse tree
	 */
	void exitFindPathCommand(ZtnParser.FindPathCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#connectCommand}.
	 * @param ctx the parse tree
	 */
	void enterConnectCommand(ZtnParser.ConnectCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#connectCommand}.
	 * @param ctx the parse tree
	 */
	void exitConnectCommand(ZtnParser.ConnectCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#disconnectCommand}.
	 * @param ctx the parse tree
	 */
	void enterDisconnectCommand(ZtnParser.DisconnectCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#disconnectCommand}.
	 * @param ctx the parse tree
	 */
	void exitDisconnectCommand(ZtnParser.DisconnectCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#allowCommand}.
	 * @param ctx the parse tree
	 */
	void enterAllowCommand(ZtnParser.AllowCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#allowCommand}.
	 * @param ctx the parse tree
	 */
	void exitAllowCommand(ZtnParser.AllowCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#denyCommand}.
	 * @param ctx the parse tree
	 */
	void enterDenyCommand(ZtnParser.DenyCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#denyCommand}.
	 * @param ctx the parse tree
	 */
	void exitDenyCommand(ZtnParser.DenyCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#clearCommand}.
	 * @param ctx the parse tree
	 */
	void enterClearCommand(ZtnParser.ClearCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#clearCommand}.
	 * @param ctx the parse tree
	 */
	void exitClearCommand(ZtnParser.ClearCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#demoCommand}.
	 * @param ctx the parse tree
	 */
	void enterDemoCommand(ZtnParser.DemoCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#demoCommand}.
	 * @param ctx the parse tree
	 */
	void exitDemoCommand(ZtnParser.DemoCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#setPolicyCommand}.
	 * @param ctx the parse tree
	 */
	void enterSetPolicyCommand(ZtnParser.SetPolicyCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#setPolicyCommand}.
	 * @param ctx the parse tree
	 */
	void exitSetPolicyCommand(ZtnParser.SetPolicyCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#addToGroupCommand}.
	 * @param ctx the parse tree
	 */
	void enterAddToGroupCommand(ZtnParser.AddToGroupCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#addToGroupCommand}.
	 * @param ctx the parse tree
	 */
	void exitAddToGroupCommand(ZtnParser.AddToGroupCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(ZtnParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(ZtnParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#extEntity}.
	 * @param ctx the parse tree
	 */
	void enterExtEntity(ZtnParser.ExtEntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#extEntity}.
	 * @param ctx the parse tree
	 */
	void exitExtEntity(ZtnParser.ExtEntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(ZtnParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(ZtnParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#to}.
	 * @param ctx the parse tree
	 */
	void enterTo(ZtnParser.ToContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#to}.
	 * @param ctx the parse tree
	 */
	void exitTo(ZtnParser.ToContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(ZtnParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(ZtnParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(ZtnParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(ZtnParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(ZtnParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(ZtnParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#newOperator}.
	 * @param ctx the parse tree
	 */
	void enterNewOperator(ZtnParser.NewOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#newOperator}.
	 * @param ctx the parse tree
	 */
	void exitNewOperator(ZtnParser.NewOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#delOperator}.
	 * @param ctx the parse tree
	 */
	void enterDelOperator(ZtnParser.DelOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#delOperator}.
	 * @param ctx the parse tree
	 */
	void exitDelOperator(ZtnParser.DelOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#search}.
	 * @param ctx the parse tree
	 */
	void enterSearch(ZtnParser.SearchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#search}.
	 * @param ctx the parse tree
	 */
	void exitSearch(ZtnParser.SearchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#connect}.
	 * @param ctx the parse tree
	 */
	void enterConnect(ZtnParser.ConnectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#connect}.
	 * @param ctx the parse tree
	 */
	void exitConnect(ZtnParser.ConnectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#disconnect}.
	 * @param ctx the parse tree
	 */
	void enterDisconnect(ZtnParser.DisconnectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#disconnect}.
	 * @param ctx the parse tree
	 */
	void exitDisconnect(ZtnParser.DisconnectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#allow}.
	 * @param ctx the parse tree
	 */
	void enterAllow(ZtnParser.AllowContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#allow}.
	 * @param ctx the parse tree
	 */
	void exitAllow(ZtnParser.AllowContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#deny}.
	 * @param ctx the parse tree
	 */
	void enterDeny(ZtnParser.DenyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#deny}.
	 * @param ctx the parse tree
	 */
	void exitDeny(ZtnParser.DenyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#rights}.
	 * @param ctx the parse tree
	 */
	void enterRights(ZtnParser.RightsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#rights}.
	 * @param ctx the parse tree
	 */
	void exitRights(ZtnParser.RightsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#access}.
	 * @param ctx the parse tree
	 */
	void enterAccess(ZtnParser.AccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#access}.
	 * @param ctx the parse tree
	 */
	void exitAccess(ZtnParser.AccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(ZtnParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(ZtnParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#policy}.
	 * @param ctx the parse tree
	 */
	void enterPolicy(ZtnParser.PolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#policy}.
	 * @param ctx the parse tree
	 */
	void exitPolicy(ZtnParser.PolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(ZtnParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(ZtnParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(ZtnParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(ZtnParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZtnParser#searchble}.
	 * @param ctx the parse tree
	 */
	void enterSearchble(ZtnParser.SearchbleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZtnParser#searchble}.
	 * @param ctx the parse tree
	 */
	void exitSearchble(ZtnParser.SearchbleContext ctx);
}
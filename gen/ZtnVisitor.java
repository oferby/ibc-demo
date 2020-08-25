// Generated from C:/dev/ibn/mock/src/main/antlr4/com.huawei.ibc/antlr4\Ztn.g4 by ANTLR 4.7

    import java.util.*;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZtnParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZtnVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZtnParser#zn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZn(ZtnParser.ZnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#showCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCommand(ZtnParser.ShowCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#newCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCommand(ZtnParser.NewCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#delCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelCommand(ZtnParser.DelCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#findPathCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFindPathCommand(ZtnParser.FindPathCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#connectCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectCommand(ZtnParser.ConnectCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#disconnectCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisconnectCommand(ZtnParser.DisconnectCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#allowCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllowCommand(ZtnParser.AllowCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#denyCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDenyCommand(ZtnParser.DenyCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#clearCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearCommand(ZtnParser.ClearCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#demoCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDemoCommand(ZtnParser.DemoCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#setPolicyCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPolicyCommand(ZtnParser.SetPolicyCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#addToGroupCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddToGroupCommand(ZtnParser.AddToGroupCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(ZtnParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#extEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtEntity(ZtnParser.ExtEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(ZtnParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo(ZtnParser.ToContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(ZtnParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(ZtnParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(ZtnParser.ShowContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#newOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewOperator(ZtnParser.NewOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#delOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelOperator(ZtnParser.DelOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#search}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch(ZtnParser.SearchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#connect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnect(ZtnParser.ConnectContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#disconnect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisconnect(ZtnParser.DisconnectContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#allow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllow(ZtnParser.AllowContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#deny}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeny(ZtnParser.DenyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#rights}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRights(ZtnParser.RightsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(ZtnParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity(ZtnParser.EntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicy(ZtnParser.PolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(ZtnParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(ZtnParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZtnParser#searchble}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchble(ZtnParser.SearchbleContext ctx);
}
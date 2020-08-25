// Generated from C:/dev/ibn/mock/src/main/antlr4/com.huawei.ibc/antlr4\Ztn.g4 by ANTLR 4.7

    import java.util.*;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ZtnParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, FROM=4, TO=5, AND=6, ADD=7, NUMBER=8, ACCESS=9, 
		TRAFFIC=10, NEW=11, POLICY=12, GROUP=13, SHOW=14, SEARCH=15, CONNECT=16, 
		DISCONNECT=17, CREATE=18, DELETE=19, ALLOW=20, DENY=21, CLEAR=22, ENTITY=23, 
		SEARCHABLE=24, DEMO=25, NEWLINE=26, NAME=27, WORD=28, WHITESPACE=29;
	public static final int
		RULE_zn = 0, RULE_showCommand = 1, RULE_newCommand = 2, RULE_delCommand = 3, 
		RULE_findPathCommand = 4, RULE_connectCommand = 5, RULE_disconnectCommand = 6, 
		RULE_allowCommand = 7, RULE_denyCommand = 8, RULE_clearCommand = 9, RULE_demoCommand = 10, 
		RULE_setPolicyCommand = 11, RULE_addToGroupCommand = 12, RULE_operator = 13, 
		RULE_extEntity = 14, RULE_from = 15, RULE_to = 16, RULE_and = 17, RULE_num = 18, 
		RULE_show = 19, RULE_newOperator = 20, RULE_delOperator = 21, RULE_search = 22, 
		RULE_connect = 23, RULE_disconnect = 24, RULE_allow = 25, RULE_deny = 26, 
		RULE_rights = 27, RULE_access = 28, RULE_entity = 29, RULE_policy = 30, 
		RULE_group = 31, RULE_name = 32, RULE_searchble = 33;
	public static final String[] ruleNames = {
		"zn", "showCommand", "newCommand", "delCommand", "findPathCommand", "connectCommand", 
		"disconnectCommand", "allowCommand", "denyCommand", "clearCommand", "demoCommand", 
		"setPolicyCommand", "addToGroupCommand", "operator", "extEntity", "from", 
		"to", "and", "num", "show", "newOperator", "delOperator", "search", "connect", 
		"disconnect", "allow", "deny", "rights", "access", "entity", "policy", 
		"group", "name", "searchble"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'all'", "'default'", "'set'", "'from'", "'to'", "'and'", "'add'", 
		null, "'access'", "'traffic'", "'new'", null, null, null, null, null, 
		null, null, null, null, null, "'clear'", null, null, "'demo'", null, null, 
		null, "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "FROM", "TO", "AND", "ADD", "NUMBER", "ACCESS", 
		"TRAFFIC", "NEW", "POLICY", "GROUP", "SHOW", "SEARCH", "CONNECT", "DISCONNECT", 
		"CREATE", "DELETE", "ALLOW", "DENY", "CLEAR", "ENTITY", "SEARCHABLE", 
		"DEMO", "NEWLINE", "NAME", "WORD", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Ztn.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    HashMap<String,String> values;

	public ZtnParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ZnContext extends ParserRuleContext {
		public Map<String,String> values;
		public ShowCommandContext showCommand;
		public FindPathCommandContext findPathCommand;
		public NewCommandContext newCommand;
		public DelCommandContext delCommand;
		public ConnectCommandContext connectCommand;
		public DisconnectCommandContext disconnectCommand;
		public AllowCommandContext allowCommand;
		public DenyCommandContext denyCommand;
		public DemoCommandContext demoCommand;
		public ClearCommandContext clearCommand;
		public SetPolicyCommandContext setPolicyCommand;
		public AddToGroupCommandContext addToGroupCommand;
		public ShowCommandContext showCommand() {
			return getRuleContext(ShowCommandContext.class,0);
		}
		public FindPathCommandContext findPathCommand() {
			return getRuleContext(FindPathCommandContext.class,0);
		}
		public NewCommandContext newCommand() {
			return getRuleContext(NewCommandContext.class,0);
		}
		public DelCommandContext delCommand() {
			return getRuleContext(DelCommandContext.class,0);
		}
		public ConnectCommandContext connectCommand() {
			return getRuleContext(ConnectCommandContext.class,0);
		}
		public DisconnectCommandContext disconnectCommand() {
			return getRuleContext(DisconnectCommandContext.class,0);
		}
		public AllowCommandContext allowCommand() {
			return getRuleContext(AllowCommandContext.class,0);
		}
		public DenyCommandContext denyCommand() {
			return getRuleContext(DenyCommandContext.class,0);
		}
		public DemoCommandContext demoCommand() {
			return getRuleContext(DemoCommandContext.class,0);
		}
		public ClearCommandContext clearCommand() {
			return getRuleContext(ClearCommandContext.class,0);
		}
		public SetPolicyCommandContext setPolicyCommand() {
			return getRuleContext(SetPolicyCommandContext.class,0);
		}
		public AddToGroupCommandContext addToGroupCommand() {
			return getRuleContext(AddToGroupCommandContext.class,0);
		}
		public ZnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterZn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitZn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitZn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZnContext zn() throws RecognitionException {
		ZnContext _localctx = new ZnContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_zn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(68);
				((ZnContext)_localctx).showCommand = showCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).showCommand.values; 
				}
				break;
			case 2:
				{
				setState(71);
				((ZnContext)_localctx).findPathCommand = findPathCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).findPathCommand.values; 
				}
				break;
			case 3:
				{
				setState(74);
				((ZnContext)_localctx).newCommand = newCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).newCommand.values; 
				}
				break;
			case 4:
				{
				setState(77);
				((ZnContext)_localctx).delCommand = delCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).delCommand.values; 
				}
				break;
			case 5:
				{
				setState(80);
				((ZnContext)_localctx).connectCommand = connectCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).connectCommand.values; 
				}
				break;
			case 6:
				{
				setState(83);
				((ZnContext)_localctx).disconnectCommand = disconnectCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).disconnectCommand.values; 
				}
				break;
			case 7:
				{
				setState(86);
				((ZnContext)_localctx).allowCommand = allowCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).allowCommand.values; 
				}
				break;
			case 8:
				{
				setState(89);
				((ZnContext)_localctx).denyCommand = denyCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).denyCommand.values; 
				}
				break;
			case 9:
				{
				setState(92);
				((ZnContext)_localctx).demoCommand = demoCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).demoCommand.values; 
				}
				break;
			case 10:
				{
				setState(95);
				((ZnContext)_localctx).clearCommand = clearCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).clearCommand.values; 
				}
				break;
			case 11:
				{
				setState(98);
				((ZnContext)_localctx).setPolicyCommand = setPolicyCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).setPolicyCommand.values; 
				}
				break;
			case 12:
				{
				setState(101);
				((ZnContext)_localctx).addToGroupCommand = addToGroupCommand();
				 ((ZnContext)_localctx).values =  ((ZnContext)_localctx).addToGroupCommand.values; 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public Token a;
		public ExtEntityContext e;
		public NameContext n;
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public ExtEntityContext extEntity() {
			return getRuleContext(ExtEntityContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ShowCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterShowCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitShowCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitShowCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowCommandContext showCommand() throws RecognitionException {
		ShowCommandContext _localctx = new ShowCommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_showCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			show();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(107);
				((ShowCommandContext)_localctx).a = match(T__0);
				}
			}

			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POLICY) | (1L << GROUP) | (1L << ENTITY))) != 0)) {
				{
				setState(110);
				((ShowCommandContext)_localctx).e = extEntity();
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(113);
				((ShowCommandContext)_localctx).n = name();
				}
			}


			                ((ShowCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "show");
			                if ((((ShowCommandContext)_localctx).n!=null?_input.getText(((ShowCommandContext)_localctx).n.start,((ShowCommandContext)_localctx).n.stop):null) != null )
			                    _localctx.values.put("name", (((ShowCommandContext)_localctx).n!=null?_input.getText(((ShowCommandContext)_localctx).n.start,((ShowCommandContext)_localctx).n.stop):null));
			                if ((((ShowCommandContext)_localctx).e!=null?_input.getText(((ShowCommandContext)_localctx).e.start,((ShowCommandContext)_localctx).e.stop):null) != null )
			                    _localctx.values.put("entity", (((ShowCommandContext)_localctx).e!=null?_input.getText(((ShowCommandContext)_localctx).e.start,((ShowCommandContext)_localctx).e.stop):null));
			                if ((((ShowCommandContext)_localctx).a!=null?((ShowCommandContext)_localctx).a.getText():null) != null )
			                    _localctx.values.put("name", "all");
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public ExtEntityContext e;
		public NameContext n;
		public Token d;
		public NewOperatorContext newOperator() {
			return getRuleContext(NewOperatorContext.class,0);
		}
		public ExtEntityContext extEntity() {
			return getRuleContext(ExtEntityContext.class,0);
		}
		public TerminalNode NEW() { return getToken(ZtnParser.NEW, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public NewCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterNewCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitNewCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitNewCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewCommandContext newCommand() throws RecognitionException {
		NewCommandContext _localctx = new NewCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_newCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			newOperator();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW) {
				{
				setState(119);
				match(NEW);
				}
			}

			setState(122);
			((NewCommandContext)_localctx).e = extEntity();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(123);
				((NewCommandContext)_localctx).n = name();
				}
			}

			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(126);
				((NewCommandContext)_localctx).d = match(T__1);
				}
			}


			                ((NewCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "create");
			                if ((((NewCommandContext)_localctx).n!=null?_input.getText(((NewCommandContext)_localctx).n.start,((NewCommandContext)_localctx).n.stop):null) != null )
			                    _localctx.values.put("name", (((NewCommandContext)_localctx).n!=null?_input.getText(((NewCommandContext)_localctx).n.start,((NewCommandContext)_localctx).n.stop):null));
			                _localctx.values.put("entity", (((NewCommandContext)_localctx).e!=null?_input.getText(((NewCommandContext)_localctx).e.start,((NewCommandContext)_localctx).e.stop):null));
			                if ((((NewCommandContext)_localctx).d!=null?((NewCommandContext)_localctx).d.getText():null) != null )
			                    _localctx.values.put("default", "true");
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public Token a;
		public ExtEntityContext e;
		public NameContext n;
		public DelOperatorContext delOperator() {
			return getRuleContext(DelOperatorContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExtEntityContext extEntity() {
			return getRuleContext(ExtEntityContext.class,0);
		}
		public DelCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDelCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDelCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDelCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelCommandContext delCommand() throws RecognitionException {
		DelCommandContext _localctx = new DelCommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_delCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			delOperator();
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(132);
				((DelCommandContext)_localctx).a = match(T__0);
				}
				break;
			case POLICY:
			case GROUP:
			case ENTITY:
			case NAME:
				{
				{
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POLICY) | (1L << GROUP) | (1L << ENTITY))) != 0)) {
					{
					setState(133);
					((DelCommandContext)_localctx).e = extEntity();
					}
				}

				setState(136);
				((DelCommandContext)_localctx).n = name();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                ((DelCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "delete");
			                if ((((DelCommandContext)_localctx).a!=null?((DelCommandContext)_localctx).a.getText():null) != null )
			                    _localctx.values.put("all", "true");
			                else {
			                    _localctx.values.put("name", (((DelCommandContext)_localctx).n!=null?_input.getText(((DelCommandContext)_localctx).n.start,((DelCommandContext)_localctx).n.stop):null));
			                    if ((((DelCommandContext)_localctx).e!=null?_input.getText(((DelCommandContext)_localctx).e.start,((DelCommandContext)_localctx).e.stop):null) != null)
			                        _localctx.values.put("entity", (((DelCommandContext)_localctx).e!=null?_input.getText(((DelCommandContext)_localctx).e.start,((DelCommandContext)_localctx).e.stop):null));
			                }

			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FindPathCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NameContext f;
		public NameContext t;
		public SearchbleContext searchble() {
			return getRuleContext(SearchbleContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public SearchContext search() {
			return getRuleContext(SearchContext.class,0);
		}
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public FindPathCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_findPathCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterFindPathCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitFindPathCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitFindPathCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindPathCommandContext findPathCommand() throws RecognitionException {
		FindPathCommandContext _localctx = new FindPathCommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_findPathCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEARCH:
				{
				setState(141);
				search();
				}
				break;
			case SHOW:
				{
				setState(142);
				show();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(145);
			searchble();
			setState(146);
			from();
			setState(147);
			((FindPathCommandContext)_localctx).f = name();
			setState(148);
			to();
			setState(149);
			((FindPathCommandContext)_localctx).t = name();

			                ((FindPathCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "findPath");
			                _localctx.values.put("from", (((FindPathCommandContext)_localctx).f!=null?_input.getText(((FindPathCommandContext)_localctx).f.start,((FindPathCommandContext)_localctx).f.stop):null));
			                _localctx.values.put("to", (((FindPathCommandContext)_localctx).t!=null?_input.getText(((FindPathCommandContext)_localctx).t.start,((FindPathCommandContext)_localctx).t.stop):null));
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConnectCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NameContext f;
		public NameContext t;
		public ConnectContext connect() {
			return getRuleContext(ConnectContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public ConnectCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterConnectCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitConnectCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitConnectCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnectCommandContext connectCommand() throws RecognitionException {
		ConnectCommandContext _localctx = new ConnectCommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_connectCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			connect();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENTITY) {
				{
				setState(153);
				entity();
				}
			}

			setState(156);
			((ConnectCommandContext)_localctx).f = name();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(157);
				to();
				}
			}

			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(160);
				and();
				}
			}

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENTITY) {
				{
				setState(163);
				entity();
				}
			}

			setState(166);
			((ConnectCommandContext)_localctx).t = name();

			                ((ConnectCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "connect");
			                _localctx.values.put("from", (((ConnectCommandContext)_localctx).f!=null?_input.getText(((ConnectCommandContext)_localctx).f.start,((ConnectCommandContext)_localctx).f.stop):null));
			                _localctx.values.put("to", (((ConnectCommandContext)_localctx).t!=null?_input.getText(((ConnectCommandContext)_localctx).t.start,((ConnectCommandContext)_localctx).t.stop):null));

			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisconnectCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NameContext f;
		public NameContext t;
		public DisconnectContext disconnect() {
			return getRuleContext(DisconnectContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public DisconnectCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disconnectCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDisconnectCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDisconnectCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDisconnectCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisconnectCommandContext disconnectCommand() throws RecognitionException {
		DisconnectCommandContext _localctx = new DisconnectCommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_disconnectCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			disconnect();
			setState(170);
			((DisconnectCommandContext)_localctx).f = name();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(171);
				from();
				}
			}

			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(174);
				and();
				}
			}

			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(177);
				((DisconnectCommandContext)_localctx).t = name();
				}
			}


			                ((DisconnectCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "disconnect");
			                _localctx.values.put("from", (((DisconnectCommandContext)_localctx).f!=null?_input.getText(((DisconnectCommandContext)_localctx).f.start,((DisconnectCommandContext)_localctx).f.stop):null));
			                if ((((DisconnectCommandContext)_localctx).t!=null?_input.getText(((DisconnectCommandContext)_localctx).t.start,((DisconnectCommandContext)_localctx).t.stop):null) != null )
			                    _localctx.values.put("to", (((DisconnectCommandContext)_localctx).t!=null?_input.getText(((DisconnectCommandContext)_localctx).t.start,((DisconnectCommandContext)_localctx).t.stop):null));

			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllowCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public Token a;
		public NameContext f;
		public NameContext t;
		public AllowContext allow() {
			return getRuleContext(AllowContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public AllowCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allowCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterAllowCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitAllowCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitAllowCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllowCommandContext allowCommand() throws RecognitionException {
		AllowCommandContext _localctx = new AllowCommandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_allowCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			allow();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(183);
				((AllowCommandContext)_localctx).a = match(T__0);
				}
			}

			setState(186);
			access();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(187);
				from();
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ENTITY) {
					{
					setState(188);
					entity();
					}
				}

				setState(191);
				((AllowCommandContext)_localctx).f = name();
				}
			}

			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TO) | (1L << ENTITY) | (1L << NAME))) != 0)) {
				{
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(195);
					to();
					}
				}

				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ENTITY) {
					{
					setState(198);
					entity();
					}
				}

				setState(201);
				((AllowCommandContext)_localctx).t = name();
				}
			}


			                ((AllowCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "allow");
			                if ((((AllowCommandContext)_localctx).f!=null?_input.getText(((AllowCommandContext)_localctx).f.start,((AllowCommandContext)_localctx).f.stop):null) != null )
			                    _localctx.values.put("from", (((AllowCommandContext)_localctx).f!=null?_input.getText(((AllowCommandContext)_localctx).f.start,((AllowCommandContext)_localctx).f.stop):null));
			                if ((((AllowCommandContext)_localctx).t!=null?_input.getText(((AllowCommandContext)_localctx).t.start,((AllowCommandContext)_localctx).t.stop):null) != null )
			                    _localctx.values.put("to", (((AllowCommandContext)_localctx).t!=null?_input.getText(((AllowCommandContext)_localctx).t.start,((AllowCommandContext)_localctx).t.stop):null));
			                if ((((AllowCommandContext)_localctx).a!=null?((AllowCommandContext)_localctx).a.getText():null) != null )
			                    _localctx.values.put("all", "true");
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DenyCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NameContext f;
		public NameContext t;
		public DenyContext deny() {
			return getRuleContext(DenyContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public DenyCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_denyCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDenyCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDenyCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDenyCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DenyCommandContext denyCommand() throws RecognitionException {
		DenyCommandContext _localctx = new DenyCommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_denyCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			deny();
			setState(207);
			access();
			setState(208);
			from();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENTITY) {
				{
				setState(209);
				entity();
				}
			}

			setState(212);
			((DenyCommandContext)_localctx).f = name();
			setState(213);
			to();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENTITY) {
				{
				setState(214);
				entity();
				}
			}

			setState(217);
			((DenyCommandContext)_localctx).t = name();

			                ((DenyCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "deny");
			                _localctx.values.put("from", (((DenyCommandContext)_localctx).f!=null?_input.getText(((DenyCommandContext)_localctx).f.start,((DenyCommandContext)_localctx).f.stop):null));
			                _localctx.values.put("to", (((DenyCommandContext)_localctx).t!=null?_input.getText(((DenyCommandContext)_localctx).t.start,((DenyCommandContext)_localctx).t.stop):null));
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClearCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public TerminalNode CLEAR() { return getToken(ZtnParser.CLEAR, 0); }
		public ClearCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clearCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterClearCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitClearCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitClearCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClearCommandContext clearCommand() throws RecognitionException {
		ClearCommandContext _localctx = new ClearCommandContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clearCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(CLEAR);

			                ((ClearCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "clear");
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DemoCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NumContext num;
		public NewOperatorContext newOperator() {
			return getRuleContext(NewOperatorContext.class,0);
		}
		public TerminalNode DEMO() { return getToken(ZtnParser.DEMO, 0); }
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public DemoCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_demoCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDemoCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDemoCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDemoCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DemoCommandContext demoCommand() throws RecognitionException {
		DemoCommandContext _localctx = new DemoCommandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_demoCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			newOperator();
			setState(224);
			match(DEMO);
			setState(225);
			((DemoCommandContext)_localctx).num = num();

			                ((DemoCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "demo");
			                _localctx.values.put("num", (((DemoCommandContext)_localctx).num!=null?_input.getText(((DemoCommandContext)_localctx).num.start,((DemoCommandContext)_localctx).num.stop):null));
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetPolicyCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NameContext pn;
		public RightsContext r;
		public NameContext f;
		public NameContext t;
		public PolicyContext policy() {
			return getRuleContext(PolicyContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public RightsContext rights() {
			return getRuleContext(RightsContext.class,0);
		}
		public SetPolicyCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setPolicyCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterSetPolicyCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitSetPolicyCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitSetPolicyCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetPolicyCommandContext setPolicyCommand() throws RecognitionException {
		SetPolicyCommandContext _localctx = new SetPolicyCommandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_setPolicyCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(228);
				match(T__2);
				}
			}

			setState(231);
			policy();
			setState(232);
			((SetPolicyCommandContext)_localctx).pn = name();
			setState(233);
			((SetPolicyCommandContext)_localctx).r = rights();
			setState(234);
			access();
			setState(235);
			from();
			setState(236);
			((SetPolicyCommandContext)_localctx).f = name();
			setState(237);
			to();
			setState(238);
			((SetPolicyCommandContext)_localctx).t = name();

			                ((SetPolicyCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "setPolicy");
			                _localctx.values.put("name", (((SetPolicyCommandContext)_localctx).pn!=null?_input.getText(((SetPolicyCommandContext)_localctx).pn.start,((SetPolicyCommandContext)_localctx).pn.stop):null));
			                _localctx.values.put("rights", (((SetPolicyCommandContext)_localctx).r!=null?_input.getText(((SetPolicyCommandContext)_localctx).r.start,((SetPolicyCommandContext)_localctx).r.stop):null));
			                _localctx.values.put("from", (((SetPolicyCommandContext)_localctx).f!=null?_input.getText(((SetPolicyCommandContext)_localctx).f.start,((SetPolicyCommandContext)_localctx).f.stop):null));
			                _localctx.values.put("to", (((SetPolicyCommandContext)_localctx).t!=null?_input.getText(((SetPolicyCommandContext)_localctx).t.start,((SetPolicyCommandContext)_localctx).t.stop):null));
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddToGroupCommandContext extends ParserRuleContext {
		public Map<String,String> values;
		public NameContext n;
		public NameContext g;
		public TerminalNode ADD() { return getToken(ZtnParser.ADD, 0); }
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public AddToGroupCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addToGroupCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterAddToGroupCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitAddToGroupCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitAddToGroupCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddToGroupCommandContext addToGroupCommand() throws RecognitionException {
		AddToGroupCommandContext _localctx = new AddToGroupCommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_addToGroupCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ADD);
			setState(242);
			((AddToGroupCommandContext)_localctx).n = name();
			setState(243);
			to();
			setState(244);
			group();
			setState(245);
			((AddToGroupCommandContext)_localctx).g = name();

			                ((AddToGroupCommandContext)_localctx).values =  new HashMap<String,String>();
			                _localctx.values.put("operator", "addToGroup");
			                _localctx.values.put("name", (((AddToGroupCommandContext)_localctx).n!=null?_input.getText(((AddToGroupCommandContext)_localctx).n.start,((AddToGroupCommandContext)_localctx).n.stop):null));
			                _localctx.values.put("group", (((AddToGroupCommandContext)_localctx).g!=null?_input.getText(((AddToGroupCommandContext)_localctx).g.start,((AddToGroupCommandContext)_localctx).g.stop):null));
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public NewOperatorContext newOperator() {
			return getRuleContext(NewOperatorContext.class,0);
		}
		public SearchContext search() {
			return getRuleContext(SearchContext.class,0);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_operator);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				show();
				}
				break;
			case ADD:
			case CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				newOperator();
				}
				break;
			case SEARCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				search();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtEntityContext extends ParserRuleContext {
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public PolicyContext policy() {
			return getRuleContext(PolicyContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public ExtEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extEntity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterExtEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitExtEntity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitExtEntity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtEntityContext extEntity() throws RecognitionException {
		ExtEntityContext _localctx = new ExtEntityContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_extEntity);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTITY:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				entity();
				}
				break;
			case POLICY:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				policy();
				}
				break;
			case GROUP:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				group();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(ZtnParser.FROM, 0); }
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(FROM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(ZtnParser.TO, 0); }
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(TO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(ZtnParser.AND, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(AND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ZtnParser.NUMBER, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(ZtnParser.SHOW, 0); }
		public ShowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitShow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitShow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowContext show() throws RecognitionException {
		ShowContext _localctx = new ShowContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_show);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(SHOW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewOperatorContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(ZtnParser.CREATE, 0); }
		public TerminalNode ADD() { return getToken(ZtnParser.ADD, 0); }
		public NewOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterNewOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitNewOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitNewOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewOperatorContext newOperator() throws RecognitionException {
		NewOperatorContext _localctx = new NewOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_newOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==CREATE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelOperatorContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(ZtnParser.DELETE, 0); }
		public DelOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDelOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDelOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDelOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelOperatorContext delOperator() throws RecognitionException {
		DelOperatorContext _localctx = new DelOperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_delOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(DELETE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchContext extends ParserRuleContext {
		public TerminalNode SEARCH() { return getToken(ZtnParser.SEARCH, 0); }
		public SearchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_search; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterSearch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitSearch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitSearch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchContext search() throws RecognitionException {
		SearchContext _localctx = new SearchContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_search);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(SEARCH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConnectContext extends ParserRuleContext {
		public TerminalNode CONNECT() { return getToken(ZtnParser.CONNECT, 0); }
		public ConnectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterConnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitConnect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitConnect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnectContext connect() throws RecognitionException {
		ConnectContext _localctx = new ConnectContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_connect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(CONNECT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisconnectContext extends ParserRuleContext {
		public TerminalNode DISCONNECT() { return getToken(ZtnParser.DISCONNECT, 0); }
		public DisconnectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disconnect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDisconnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDisconnect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDisconnect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisconnectContext disconnect() throws RecognitionException {
		DisconnectContext _localctx = new DisconnectContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_disconnect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(DISCONNECT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllowContext extends ParserRuleContext {
		public TerminalNode ALLOW() { return getToken(ZtnParser.ALLOW, 0); }
		public AllowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterAllow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitAllow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitAllow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllowContext allow() throws RecognitionException {
		AllowContext _localctx = new AllowContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_allow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(ALLOW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DenyContext extends ParserRuleContext {
		public TerminalNode DENY() { return getToken(ZtnParser.DENY, 0); }
		public DenyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deny; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterDeny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitDeny(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitDeny(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DenyContext deny() throws RecognitionException {
		DenyContext _localctx = new DenyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_deny);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(DENY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightsContext extends ParserRuleContext {
		public TerminalNode ALLOW() { return getToken(ZtnParser.ALLOW, 0); }
		public TerminalNode DENY() { return getToken(ZtnParser.DENY, 0); }
		public RightsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rights; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterRights(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitRights(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitRights(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightsContext rights() throws RecognitionException {
		RightsContext _localctx = new RightsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rights);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !(_la==ALLOW || _la==DENY) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessContext extends ParserRuleContext {
		public TerminalNode ACCESS() { return getToken(ZtnParser.ACCESS, 0); }
		public TerminalNode TRAFFIC() { return getToken(ZtnParser.TRAFFIC, 0); }
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !(_la==ACCESS || _la==TRAFFIC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntityContext extends ParserRuleContext {
		public TerminalNode ENTITY() { return getToken(ZtnParser.ENTITY, 0); }
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitEntity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitEntity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_entity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(ENTITY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolicyContext extends ParserRuleContext {
		public TerminalNode POLICY() { return getToken(ZtnParser.POLICY, 0); }
		public PolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterPolicy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitPolicy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitPolicy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolicyContext policy() throws RecognitionException {
		PolicyContext _localctx = new PolicyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_policy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(POLICY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(ZtnParser.GROUP, 0); }
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(GROUP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ZtnParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchbleContext extends ParserRuleContext {
		public TerminalNode SEARCHABLE() { return getToken(ZtnParser.SEARCHABLE, 0); }
		public SearchbleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).enterSearchble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZtnListener ) ((ZtnListener)listener).exitSearchble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZtnVisitor ) return ((ZtnVisitor<? extends T>)visitor).visitSearchble(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchbleContext searchble() throws RecognitionException {
		SearchbleContext _localctx = new SearchbleContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_searchble);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(SEARCHABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u012b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2k\n\2\3\3\3\3\5\3o\n\3\3\3\5\3r\n\3\3\3\5\3"+
		"u\n\3\3\3\3\3\3\4\3\4\5\4{\n\4\3\4\3\4\5\4\177\n\4\3\4\5\4\u0082\n\4\3"+
		"\4\3\4\3\5\3\5\3\5\5\5\u0089\n\5\3\5\5\5\u008c\n\5\3\5\3\5\3\6\3\6\5\6"+
		"\u0092\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7\u009d\n\7\3\7\3\7\5"+
		"\7\u00a1\n\7\3\7\5\7\u00a4\n\7\3\7\5\7\u00a7\n\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\5\b\u00af\n\b\3\b\5\b\u00b2\n\b\3\b\5\b\u00b5\n\b\3\b\3\b\3\t\3\t\5"+
		"\t\u00bb\n\t\3\t\3\t\3\t\5\t\u00c0\n\t\3\t\3\t\5\t\u00c4\n\t\3\t\5\t\u00c7"+
		"\n\t\3\t\5\t\u00ca\n\t\3\t\5\t\u00cd\n\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u00d5"+
		"\n\n\3\n\3\n\3\n\5\n\u00da\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\5\r\u00e8\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00fe\n\17\3\20\3\20"+
		"\3\20\5\20\u0103\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\2\2$\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\5\4\2"+
		"\t\t\24\24\3\2\26\27\3\2\13\f\2\u0130\2j\3\2\2\2\4l\3\2\2\2\6x\3\2\2\2"+
		"\b\u0085\3\2\2\2\n\u0091\3\2\2\2\f\u009a\3\2\2\2\16\u00ab\3\2\2\2\20\u00b8"+
		"\3\2\2\2\22\u00d0\3\2\2\2\24\u00de\3\2\2\2\26\u00e1\3\2\2\2\30\u00e7\3"+
		"\2\2\2\32\u00f3\3\2\2\2\34\u00fd\3\2\2\2\36\u0102\3\2\2\2 \u0104\3\2\2"+
		"\2\"\u0106\3\2\2\2$\u0108\3\2\2\2&\u010a\3\2\2\2(\u010c\3\2\2\2*\u010e"+
		"\3\2\2\2,\u0110\3\2\2\2.\u0112\3\2\2\2\60\u0114\3\2\2\2\62\u0116\3\2\2"+
		"\2\64\u0118\3\2\2\2\66\u011a\3\2\2\28\u011c\3\2\2\2:\u011e\3\2\2\2<\u0120"+
		"\3\2\2\2>\u0122\3\2\2\2@\u0124\3\2\2\2B\u0126\3\2\2\2D\u0128\3\2\2\2F"+
		"G\5\4\3\2GH\b\2\1\2Hk\3\2\2\2IJ\5\n\6\2JK\b\2\1\2Kk\3\2\2\2LM\5\6\4\2"+
		"MN\b\2\1\2Nk\3\2\2\2OP\5\b\5\2PQ\b\2\1\2Qk\3\2\2\2RS\5\f\7\2ST\b\2\1\2"+
		"Tk\3\2\2\2UV\5\16\b\2VW\b\2\1\2Wk\3\2\2\2XY\5\20\t\2YZ\b\2\1\2Zk\3\2\2"+
		"\2[\\\5\22\n\2\\]\b\2\1\2]k\3\2\2\2^_\5\26\f\2_`\b\2\1\2`k\3\2\2\2ab\5"+
		"\24\13\2bc\b\2\1\2ck\3\2\2\2de\5\30\r\2ef\b\2\1\2fk\3\2\2\2gh\5\32\16"+
		"\2hi\b\2\1\2ik\3\2\2\2jF\3\2\2\2jI\3\2\2\2jL\3\2\2\2jO\3\2\2\2jR\3\2\2"+
		"\2jU\3\2\2\2jX\3\2\2\2j[\3\2\2\2j^\3\2\2\2ja\3\2\2\2jd\3\2\2\2jg\3\2\2"+
		"\2k\3\3\2\2\2ln\5(\25\2mo\7\3\2\2nm\3\2\2\2no\3\2\2\2oq\3\2\2\2pr\5\36"+
		"\20\2qp\3\2\2\2qr\3\2\2\2rt\3\2\2\2su\5B\"\2ts\3\2\2\2tu\3\2\2\2uv\3\2"+
		"\2\2vw\b\3\1\2w\5\3\2\2\2xz\5*\26\2y{\7\r\2\2zy\3\2\2\2z{\3\2\2\2{|\3"+
		"\2\2\2|~\5\36\20\2}\177\5B\"\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2"+
		"\2\u0080\u0082\7\4\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\b\4\1\2\u0084\7\3\2\2\2\u0085\u008b\5,\27\2\u0086"+
		"\u008c\7\3\2\2\u0087\u0089\5\36\20\2\u0088\u0087\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\5B\"\2\u008b\u0086\3\2\2\2\u008b"+
		"\u0088\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\5\1\2\u008e\t\3\2\2\2"+
		"\u008f\u0092\5.\30\2\u0090\u0092\5(\25\2\u0091\u008f\3\2\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\5D#\2\u0094\u0095\5 \21\2\u0095"+
		"\u0096\5B\"\2\u0096\u0097\5\"\22\2\u0097\u0098\5B\"\2\u0098\u0099\b\6"+
		"\1\2\u0099\13\3\2\2\2\u009a\u009c\5\60\31\2\u009b\u009d\5<\37\2\u009c"+
		"\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\5B"+
		"\"\2\u009f\u00a1\5\"\22\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u00a4\5$\23\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a7\5<\37\2\u00a6\u00a5\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\5B\"\2\u00a9\u00aa\b\7"+
		"\1\2\u00aa\r\3\2\2\2\u00ab\u00ac\5\62\32\2\u00ac\u00ae\5B\"\2\u00ad\u00af"+
		"\5 \21\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00b2\5$\23\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2"+
		"\2\2\u00b3\u00b5\5B\"\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\b\b\1\2\u00b7\17\3\2\2\2\u00b8\u00ba\5\64\33"+
		"\2\u00b9\u00bb\7\3\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00c3\5:\36\2\u00bd\u00bf\5 \21\2\u00be\u00c0\5<\37\2\u00bf"+
		"\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\5B"+
		"\"\2\u00c2\u00c4\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00cc\3\2\2\2\u00c5\u00c7\5\"\22\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00ca\5<\37\2\u00c9\u00c8\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\5B\"\2\u00cc\u00c6\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b\t\1\2\u00cf"+
		"\21\3\2\2\2\u00d0\u00d1\5\66\34\2\u00d1\u00d2\5:\36\2\u00d2\u00d4\5 \21"+
		"\2\u00d3\u00d5\5<\37\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d7\5B\"\2\u00d7\u00d9\5\"\22\2\u00d8\u00da\5<\37\2\u00d9"+
		"\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\5B"+
		"\"\2\u00dc\u00dd\b\n\1\2\u00dd\23\3\2\2\2\u00de\u00df\7\30\2\2\u00df\u00e0"+
		"\b\13\1\2\u00e0\25\3\2\2\2\u00e1\u00e2\5*\26\2\u00e2\u00e3\7\33\2\2\u00e3"+
		"\u00e4\5&\24\2\u00e4\u00e5\b\f\1\2\u00e5\27\3\2\2\2\u00e6\u00e8\7\5\2"+
		"\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea"+
		"\5> \2\u00ea\u00eb\5B\"\2\u00eb\u00ec\58\35\2\u00ec\u00ed\5:\36\2\u00ed"+
		"\u00ee\5 \21\2\u00ee\u00ef\5B\"\2\u00ef\u00f0\5\"\22\2\u00f0\u00f1\5B"+
		"\"\2\u00f1\u00f2\b\r\1\2\u00f2\31\3\2\2\2\u00f3\u00f4\7\t\2\2\u00f4\u00f5"+
		"\5B\"\2\u00f5\u00f6\5\"\22\2\u00f6\u00f7\5@!\2\u00f7\u00f8\5B\"\2\u00f8"+
		"\u00f9\b\16\1\2\u00f9\33\3\2\2\2\u00fa\u00fe\5(\25\2\u00fb\u00fe\5*\26"+
		"\2\u00fc\u00fe\5.\30\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc"+
		"\3\2\2\2\u00fe\35\3\2\2\2\u00ff\u0103\5<\37\2\u0100\u0103\5> \2\u0101"+
		"\u0103\5@!\2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2"+
		"\2\u0103\37\3\2\2\2\u0104\u0105\7\6\2\2\u0105!\3\2\2\2\u0106\u0107\7\7"+
		"\2\2\u0107#\3\2\2\2\u0108\u0109\7\b\2\2\u0109%\3\2\2\2\u010a\u010b\7\n"+
		"\2\2\u010b\'\3\2\2\2\u010c\u010d\7\20\2\2\u010d)\3\2\2\2\u010e\u010f\t"+
		"\2\2\2\u010f+\3\2\2\2\u0110\u0111\7\25\2\2\u0111-\3\2\2\2\u0112\u0113"+
		"\7\21\2\2\u0113/\3\2\2\2\u0114\u0115\7\22\2\2\u0115\61\3\2\2\2\u0116\u0117"+
		"\7\23\2\2\u0117\63\3\2\2\2\u0118\u0119\7\26\2\2\u0119\65\3\2\2\2\u011a"+
		"\u011b\7\27\2\2\u011b\67\3\2\2\2\u011c\u011d\t\3\2\2\u011d9\3\2\2\2\u011e"+
		"\u011f\t\4\2\2\u011f;\3\2\2\2\u0120\u0121\7\31\2\2\u0121=\3\2\2\2\u0122"+
		"\u0123\7\16\2\2\u0123?\3\2\2\2\u0124\u0125\7\17\2\2\u0125A\3\2\2\2\u0126"+
		"\u0127\7\35\2\2\u0127C\3\2\2\2\u0128\u0129\7\32\2\2\u0129E\3\2\2\2\36"+
		"jnqtz~\u0081\u0088\u008b\u0091\u009c\u00a0\u00a3\u00a6\u00ae\u00b1\u00b4"+
		"\u00ba\u00bf\u00c3\u00c6\u00c9\u00cc\u00d4\u00d9\u00e7\u00fd\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
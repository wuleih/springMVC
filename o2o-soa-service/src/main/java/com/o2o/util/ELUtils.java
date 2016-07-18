package com.o2o.util;

import java.io.PrintStream;
import java.io.StringReader;
import java.util.Map;

import javax.servlet.jsp.el.ELException;

import org.apache.commons.el.Expression;
import org.apache.commons.el.ExpressionString;
import org.apache.commons.el.Logger;
import org.apache.commons.el.MockFunctionMapper;
import org.apache.commons.el.MockVariableResolver;
import org.apache.commons.el.parser.ELParser;
import org.apache.commons.el.parser.ParseException;

public class ELUtils {
	public static Object evaluate(String expression, Map variables) throws Exception {        
		try {
			MockVariableResolver resolver = new MockVariableResolver(variables);
		    MockFunctionMapper mapper = new MockFunctionMapper(variables);
		    PrintStream pOut = System.out;
		    Logger plogger = new Logger(pOut);
            StringReader rdr = new StringReader(expression);
            ELParser parser = new ELParser(rdr);
            Object result = parser.ExpressionString();
            if(result instanceof String) {
                return (String) result;
            } else if(result instanceof Expression) {
                Expression expr = (Expression) result;
                result = expr.evaluate(resolver, mapper, plogger);
                return result == null ? null : result.toString();
            } else if(result instanceof ExpressionString) {
            	ExpressionString expr = (ExpressionString) result;            	
                result = expr.evaluate(resolver, mapper, plogger);
                return result == null ? null : result.toString();
            } else {
                throw new RuntimeException("Incorrect type returned; not String, Expression or ExpressionString");
            }
        } catch(ParseException pe) {
            throw new RuntimeException("ParseException thrown: " + pe.getMessage(), pe);
        } catch(ELException ele) {
            throw new RuntimeException("ELException thrown: " + ele.getMessage(), ele);
        }
    }
}

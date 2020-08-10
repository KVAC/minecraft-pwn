/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kvac.minecraft_pwn.init;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jline.builtins.Completers;
import org.jline.reader.Completer;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.ParsedLine;
import org.jline.reader.Parser;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import ysomap.common.util.Strings;

/**
 *
 * @author jdcs_dev
 */
public class Init {

    static private Map<String, String> prompt = new LinkedHashMap<>();

    static private String ysomap = "HEEE:>";

    public static void main(String[] args) {
        Terminal terminal = null;
        LineReader lineReader = null;
        Parser parser = new DefaultParser();
        try {
            terminal = TerminalBuilder.builder()
                    .system(true)
                    .build();
            Completers.CompletionEnvironment completionEnviroment = new Completers.CompletionEnvironment() {
                @Override
                public Map<String, List<Completers.CompletionData>> getCompletions() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Set<String> getCommands() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public String resolveCommand(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public String commandName(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object evaluate(LineReader reader, ParsedLine pl, String string) throws Exception {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Completer completer = new Completers.Completer(completionEnviroment);
            lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(completer)
                    .parser(parser)
                    .build();
            while (true) {
                List<String> words;
                try {
                    lineReader.readLine(makePrompt());
                    words = lineReader.getParsedLine().words();
                    System.out.println(words + "[::]" + prompt);
                    //       session.accept(words, prompt);
                } catch (UserInterruptException e) {
                    // Do nothing
                } catch (EndOfFileException e) {
                    System.out.println("\nBye.");
                    System.exit(0);
                } catch (Exception e) {
                    e.printStackTrace(); // 直接打印 防止某些应用返回的错误信息有用
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String makePrompt() {
        List<String> prompts = new LinkedList<>();
        prompts.add(ysomap);
        prompts.addAll(prompt.values());
        String temp = Strings.join(prompts, " ", "", "");
        return temp + " > ";
    }
}

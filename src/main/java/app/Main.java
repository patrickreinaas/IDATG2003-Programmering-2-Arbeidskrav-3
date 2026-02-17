/**
 * IDATG2003 - Programmering 2
 *
 * This program is developed in correlation to assignment 3 in the course IDATG2003.
 * The program is a simple API for text manipulation, allowing users to create scripts
 * of text commands that can be executed on a given text.
 * The API includes commands for capitalizing text, replacing text, and wrapping text, among others.
 * The main class demonstrates how to create a script of text commands and execute it.
 *
 * file     Main.java
 * @author  Patrick Reinås
 * @version 0.0.2
 * @since   17.02.2026
 */


package app;

import capitalize.CapitalizeSelectionTextCommand;
import capitalize.CapitalizeTextCommand;
import capitalize.CapitalizeWordsTextCommand;
import java.util.ArrayList;
import java.util.List;
import replace.ReplaceFirstTextCommand;
import replace.ReplaceTextCommand;
import script.Script;
import text.TextCommand;
import wrap.WrapSelectionTextCommand;
import wrap.WrapTextCommand;
import wrap.WrapLinesTextCommand;


/*
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        String text = "starting down!\none\n2\nthree\n4\nfive\ncountdown finished!";
        List<TextCommand> countDownScript = new ArrayList<>();
        countDownScript.add(new CapitalizeTextCommand());
        countDownScript.add(new ReplaceFirstTextCommand("down", "countdown"));
        countDownScript.add(new ReplaceFirstTextCommand("one", "1"));
        countDownScript.add(new ReplaceFirstTextCommand("three", "3"));
        countDownScript.add(new ReplaceFirstTextCommand("five", "5"));
        countDownScript.add(new WrapLinesTextCommand("[", "]"));

        Script script = new Script(countDownScript);
        System.out.println(script.execute(text));
    }
}
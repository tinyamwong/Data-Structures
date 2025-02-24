package edu.wit.comp2000.group23.application3.Tests;

import edu.wit.comp2000.group23.application3.Utilities.Event;
import edu.wit.comp2000.group23.application3.Utilities.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * Created by beznosm on 10/26/2016.
 */
public class LoggerTest {
    @Test
    public void FlushQueueTest() throws Exception {
        //system.out capturer.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        //catches system.out
        Logger lg = new Logger(ps);
        Assert.assertEquals("", new String(baos.toByteArray(), StandardCharsets.UTF_8));
        lg.AddEvent(new Event("classname", 1, "message"));
        lg.Sync();
        Assert.assertEquals("[0][classname\t\t][1\t][message]", new String(baos.toByteArray(), StandardCharsets.UTF_8).trim());
    }

    @Test
    public void TickCountTest() throws Exception {
        //system.out capturer
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        //catches system.out
        Logger lg = new Logger(ps);
        lg.AddEvent(new Event("classname", 1, "message"));
        lg.Sync();
        lg.AddEvent(new Event("classname", 2, "message"));
        lg.Sync();
        Assert.assertEquals("[0][classname\t\t][1\t][message]\n[1][classname\t\t][2\t][message]",
                baos.toString().trim().replace("\r", ""));

    }

    @Test
    public void ValidateDefaultLogger() throws Exception {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new java.io.PrintStream(out));
        Logger logger = new Logger();
        logger.AddEvent(new Event("classname", 1, "message"));
        logger.Sync();
        Assert.assertEquals("[0][classname\t\t][1\t][message]", out.toString().trim());
        System.setOut(old);
    }
}
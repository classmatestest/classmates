package com.mailru.classmates;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

/**
 * Simple CLI runner
 */
public class Runner
{
  public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
  {
    TestNG testng = new TestNG();
    for( XmlSuite xmlSuite : new Parser( "testng-xml/testng.xml" ).parseToList() )
    {
      testng.setCommandLineSuite( xmlSuite );
    }
    testng.run();
  }
}

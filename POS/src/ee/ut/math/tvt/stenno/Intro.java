package ee.ut.math.tvt.stenno;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.PropertyConfigurator;

public class Intro {

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		IntroUI uks = new IntroUI();
		uks.kuvaintro();

	}

}

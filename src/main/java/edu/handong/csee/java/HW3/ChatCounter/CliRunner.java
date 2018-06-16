package edu.handong.csee.java.HW3.ChatCounter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * @version java version "9.0.4"
 * @author Lee MyeongHui
 * This class defines a CliRunner object
 * The CliRunner class has inputPath, outputPath, help members
 * The CliRunner class has run(), parseOptions(), printHelp(), createOptions() methods 
 *
 */
public class CliRunner {
	private String inputPath;
	private String outputPath;
	private String coreNum;
	private boolean help;

	public void run(String[] args)
	{
		Options options=createOptions();

		if(parseOptions(options,args)){
			if(help) {
				printHelp(options);
				return;
			}
		}
	}
	private boolean parseOptions(Options options,String[] args)
	{
		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine c=parser.parse(options, args);

			inputPath=c.getOptionValue("i");
			outputPath=c.getOptionValue("o");
			coreNum=c.getOptionValue("c");
			help=c.hasOption("h");
		}catch(Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}

	private void printHelp(Options options) {
		HelpFormatter test=new HelpFormatter();
		String header="CLI program";
		String footer="\nThis program is count how many time chating on kakao";
		test.printHelp("CLIExample",header,options,footer,true);
	}

	private Options createOptions() {
		Options options =new Options();

		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set a path of a directory that input data")
				.hasArg()
				.argName("input option")
				.required()
				.build());

		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set a path of a directory that output data")
				.hasArg()
				.argName("output option")
				.required()
				.build());
		
		options.addOption(Option.builder("c").longOpt("corenum")
				.desc("Set a path of a directory that output data")
				.hasArg()
				.argName("corenum option")
				.required()
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;

	}

}

/*
 * @(#)hello.java $version 2016. 4. 26.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.crsh.cli.Command;
import org.crsh.cli.Option;
import org.crsh.cli.Usage;
import org.crsh.command.BaseCommand;

/**
 * @author serivires
 */
public class date extends BaseCommand {
	@Usage("show the current time")
	@Command
	public Object main(@Usage("the time format") @Option(names = {"f", "format"}) String format) {
		if (format == null)
			format = "EEE MMM d HH:mm:ss z yyyy";
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
}

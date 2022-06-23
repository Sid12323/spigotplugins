package me.sciencesid.calculate.commands;

import me.sciencesid.calculate.helpers.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Calculate implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        boolean console = false;
        if(!(commandSender instanceof Player)) {
            Msg.send(commandSender, "&cRunning Console Ed.!");
            console = true;
        }
        if (args.length == 3 || (args.length == 2 && args[1].equals("sqrt"))) {
            String op = args[1];
            double out;
            switch (op) {
                case "+" -> out = Double.parseDouble(args[0]) + Double.parseDouble(args[2]);
                case "-" -> out = Double.parseDouble(args[0]) - Double.parseDouble(args[2]);
                case "*" -> out = Double.parseDouble(args[0]) * Double.parseDouble(args[2]);
                case "/" -> out = Double.parseDouble(args[0]) / Double.parseDouble(args[2]);
                case "^" -> out = Math.pow(Double.parseDouble(args[0]),Double.parseDouble(args[2]));
                case "%" -> out = Double.parseDouble(args[0]) % Double.parseDouble(args[2]);
                case "sqrt" -> out = Math.sqrt(Double.parseDouble(args[0]));
                default -> {
                    Msg.send(commandSender, "&4 Invalid Usage: /calculate <num1> [+,-,/,*,^,%,sqrt (num1 only)] <num2>");
                    return true;
                }
            }
            String fin = args[0]+" "+args[1];
            if (args.length == 3) {fin += " "+args[2];}
            if (console) {
                System.out.println(fin);
                System.out.println("= "+out);
            } else {
                String finite = "&b= " + out;
                Msg.send(commandSender, fin);
                Msg.send(commandSender, finite);
            }
        } else {
            Msg.send(commandSender, "&4 Invalid Usage: /calculate <num1> [+,-,/,*,^,%,sqrt (num1 only)] <num2>");
        }
        return true;
    }
}

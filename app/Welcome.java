package app;

import utils.DataCollector;
import utils.DateOfDeathAdder;
import utils.DuplicateSsn;
import utils.Retrievers.PersonRetriever;
import utils.editors.PersonEditor;

import java.util.Map;

import gui.AgeStatisticsGUI;
import menu.Intro;

import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Welcome {

    public static void main(String[] args) {
        Intro.mainMenu();

        // int age = 40; // Change the age to the desired value
        // AgeStatisticsGUI.calculateAgeStatistics(age);

    }
}

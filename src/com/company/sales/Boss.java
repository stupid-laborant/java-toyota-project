package com.company.sales;

import java.io.FileWriter;
import java.io.IOException;

public class Boss {
    private Manager[] managers;
    private String name;

    public Boss(Manager[] managers, String name) {
        this.managers = managers;
        this.name = name;
    }

    public void createReport() throws IOException {
        try (FileWriter writer = new FileWriter("boss " + name + " report.txt", false)){
            for (int i = 0; i < managers.length; i++) {
                Manager manager = managers[i];
                writer.write(manager.getName() + " " + manager.getTotalIncome() + " " + manager.getTotalCost() + " " + manager.getTotalProfit() + System.lineSeparator());
            }
            writer.flush();
        }
    }


}

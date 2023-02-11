package printer;

public interface ISummary {
    default public void printSummary(){
        System.out.println("\t============== At the end  ==============");
        String cyan = "\u001B[36m";
        System.out.println(cyan + "-This is a clear and concise summary of the simulation" +
                "\nresults. The focus on the creation of every task and its assigned" +
                "\nprocessor will help you better understand the behavior of the CPU" +
                "\nduring the simulation.\n" + Print.RESET);
        for(String s : Print.lines){
            System.out.println(s);
        }
    }
}

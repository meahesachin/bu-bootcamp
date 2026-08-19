import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {

    //Setup variables for high and low scores globally so they can be accessed in multiple methods
    static int high = Integer.MAX_VALUE; // Initialize to max, so we have a valid comparison for the first score read from the file
    static int low = Integer.MIN_VALUE;  // Initialize to min value, so we have a valid comparison for the first score read from the file

    //intialize GradeBands
    static int countA = 0;
    static int countB = 0;
    static int countC = 0;      
    static int countD = 0;  
    static int countF = 0;

    // Set up counters to keep track of total lines in the file and valid scores read from the file
    static int totalLines = 0;
    static int validScores = 0;

    public static void main(String[] args) {

        // Where are the scores stored? You can change this to a different file name if you want to test with a different file.
        String inputFile = "scores.txt"; // Input file name

        //Clear the output file before writing to it, so we don't append to an old report
        //Purposefully eat the error here, because we don't care if the file doesn't exist yet. We just want to make sure it's empty before we write to it.
        try (PrintWriter pw = new PrintWriter(new FileWriter("report.txt"))) {
            pw.println("Grade Report");
            pw.println("============");
        } catch (IOException e) {
            //Very purposefully ignore this error, because we don't care if the file doesn't exist yet. We just want to make sure it's empty before we write to it.
        }

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);
        
        if (scores.isEmpty()) {
            System.out.println("No valid scores found in the file.");
            return;
        }

        validScores = scores.size(); // Update validScores after reading the scores

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        
        // Step 3: write and print report
        writeReport(scores, avg, high, low, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {

                    totalLines++; // Increment total lines read from the file

                    if(line.trim().isEmpty()) {
                        System.out.println("Empty line found, skipping.");
                    }else {
                        int score = Integer.parseInt(line);

                        scores.add(score);

                        // Update high and low scores based on the current score read from the file
                        if (score > high || high == Integer.MAX_VALUE) { // Update high only if it's greater than current high or if high is still Integer.MAX_VALUE (first valid score)
                            high = score;
                        }

                        if ( score < low || low == Integer.MIN_VALUE) { // Update low only if it's less than current low or if low is still Integer.MIN_VALUE (first valid score)
                            low = score;
                        }

                        // Update band counts based on the current score read from the file
                        if (score >= 90) {
                            countA++;
                        } else if (score >= 80) {
                            countB++;
                        } else if (score >= 70) {
                            countC++;
                        } else if (score >= 60) {
                            countD++;
                        } else {
                            countF++;   
                        }
                        
                    }
                    
                } catch (NumberFormatException e) {
                    System.out.println(line + " is not a valid integer, skipping.");
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scores;

    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        try {
            if (scores.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            return (double) sum / scores.size();
        } catch (ArithmeticException e) {
            System.out.println("Error calculating average: " + e.getMessage());
            return 0.0;
        }
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("=== Grade Analysis Report ===\n");
            
            bw.write("Total Scores Processed: " + validScores + "\n");
            bw.write("Invalid lines skipped: " +  (totalLines - validScores) + "\n");

            bw.write("\n");

            bw.write("Average Score: " + avg + "\n");
            bw.write("Highest Score: " + high + "\n");
            bw.write("Lowest Score: " + low + "\n");

            bw.write("\n");

            bw.write("Grade Distribution:\n");
            bw.write("A (90-100): " + countA + "\n");
            bw.write("B (80-89): " + countB + "\n");
            bw.write("C (70-79): " + countC + "\n");
            bw.write("D (60-69): " + countD + "\n");
            bw.write("F (below 60):  " + countF + "\n");    

            
            System.out.println("Report written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();        
    }
} 
}

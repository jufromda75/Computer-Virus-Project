import java.util.Arrays;
public class ComputerProjectAssignment {
	public static void main(String[] args) {
	    int N = 1000;
	    
	    
	    int days[] = new int[N]; // days array //
	    int all_infected = 0; // intitial declaration of t of total infected //
	    int sim = 1; // keeps track of simulation when printing //
	    int has_been = 0; // amount of computers that has been infected //
	   
	    for (int Ju = 0; Ju < N; Ju++) { // simulation for loop 
	    int days_count = 0;
	    System.out.println("---------  " + sim + " simulation  ------");
	    sim++;  
	      int n = 1; // current day for simulation //
	      int cN = 20;
	      int comp[] = new int[cN]; // array for each computer //
	      comp[0] = 1; // initial infection for computer one //
	      int infected = 0; // initial infection //
	      boolean done = true;
	      int infect[] = new int[20]; // if it has been infected array //
	      int inf [] = new int[20]; // current infection array //
	      while (done) { // start of day loop //
	    	if (n >= 2) { // if the current day is 2 or greater than it makes the current infected 0 and lets the for loop later on counts it //
	    		for (int c = 0; c < inf.length; c++) {
	    			if (inf[c] == 1) {
	    				infected = infected - 1;
	    			}
	    		}
	    		System.out.println("Current number of infected for Day " + n + ": " + infected);
	    	}
	        double prob = 0.1; // probability of infection //
	        // number of computers
	        
	        int count = 0;
	        if (n == 1) {
	        for (int i = 1; i < cN; i++) {
	          comp[i] = 0;
	        }
	        }
	        System.out.println("Day " + n + ": " + Arrays.toString(comp));

	        // For each wire "infected -> noninfected":
	        // perform a Bernoulli trial with probability p=0.1;
	        // if success, computer #j becomes newly_infected (set to 2).

	        for (int i = 0; i < cN; i++) {
	          for (int j = 0; j < cN; j++) {
	            if ((comp[i] == 1) && (comp[j] == 0)) {
	              int x = MyBernoulli(prob);
	              if (x == 1) {
	                comp[j] = 2;
	              }
	            }
	          }
	        }

	        // After that, mark all newly_infected as simply infected.
	        for (int i = 0; i < cN; i++) {
	          if (comp[i] == 2) {
	            comp[i] = 1;
              
	          }
	        }
	        System.out.println("Day " + n + ": " + Arrays.toString(comp));
          
	        for (int i = 0; i < cN; i++) { // gets the number of infected computers and stores them into a infected loop //
            
	          if(comp[i] == 1) {
	        	inf[i] = 1;
	        	infect[i] = 1;
	        	
	        	
	          infected = infected + 1;
	          }
	          
	        }
	        int was_infected = infected;
	        System.out.println("Current number of infected before cleaning for Day " + n + ": " + infected);
	        if (infected <= 5) { // if the number of infected is less than or = 5 than it cleans all of them and ends the simulation // 
				  for (int ju = 0; ju < comp.length; ju++) {
					  if (comp[ju] == 1) { //if the computer is infected at the index then it will make it clean //
						  comp[ju] = 0;
						  inf[ju] = 0;
						  
					  }
				  }
          // after all is done the infected count is 0 and simulation is done // 
				  infected = 0;
				  done = false;
			  }
	          int v = 0;
	          boolean com = false;
			  if (was_infected > 5) {
				  for (v = 0; v < cN; v++) {
					  if (count == 5) {
						  continue;
					  }
					  if (comp[v] == 1) {
						  comp[v] = 0;
						  inf[v] = 0;
						  infected--;
						  count++;
					  }
				  }
				}
			  
	        // = cleaned(infected, comp, inf);
	    
	        
	        System.out.println("Day " + n + " After cleaning: " + Arrays.toString(comp));
          System.out.println("Day " + n + " After cleaning: " + Arrays.toString(inf));
	        System.out.println("The amount of infected computers after cleaning are: " + infected);
	        days_count++; // the day counter goes up for day array //
	        n++; // current day increases //
	        
	       
	      } // end of day loop 
	      int total_infected = 0;
	      // variable for total computers that has been affected in each simulation //
	      days[Ju] = days_count; // stores the amount of days it took for each simulation //
	      System.out.println(Arrays.toString(infect)); // prints out each computer infected array // 
	      for (int g = 0; g < cN; g++) {
	    	  if (infect[g] == 1) {
	    		 total_infected++; // if the computer has been infected in the simulation then the total infected variable goes up by one // 
	    	  }
	      }
	      has_been = total_infected + has_been;
	      if (total_infected == 20) { //
	    	  all_infected++;
	      }
	    } // end of simulation of array // 
	    System.out.println(Arrays.toString(days)); // prints out days array //
	    int days_avg = 0; 
	    for (int z = 0; z < days.length; z++){
	    days_avg = days_avg + days[z];
	    }
	    double clean = (double) days_avg / N;
	    double at_least = (double) all_infected / N;
	    double all = (double) has_been / N;
	    System.out.println("The average days it take for a computer to be clean is " + clean + " days");
	    System.out.println("The probability that at least all computers been infected for a simulation is: " + at_least);
	    System.out.println("The probability that for all computers has been infected to the number of simulations is: " + all);
	    }

	  public static int MyBernoulli(double p) {
	    double U = Math.random();
	    int X;
	    if (U > 1 - p) {
	      X = 1;
	    } else {
	      X = 0;
	    }
	    return X;
	  }

	 /* public static int cleaned(int infected, int comp[], int arr[]) {
		  
		  if (infected <= 5) {
			  for (int ju = 0; ju < comp.length; ju++) {
				  if (comp[ju] == 1)+ {
					  comp[ju] = 0;
					  infected = infected - 1;
				  }
			  }
		  }
		  if (infected > 5) {
			  for (int za = 0; za < 5; za++) {
				  int random_index = (int)(Math.random() * comp.length);
				  while (comp[random_index] == 0) {
					  random_index = (int)(Math.random() * comp.length);
				  }
				  comp[random_index] = 0;
				  infected = infected - 1;
			  }
		  }
	  // return infected; 
	  } */
	 
	}

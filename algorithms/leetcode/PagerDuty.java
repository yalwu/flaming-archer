/**

Problem Description
PagerDuty creates a stream of incidents for each high-priority issue detected by our customers' monitoring systems. Each incident has a trigger time and a resolve time, each represented in Unix time (i.e., an integer containing the number of seconds since midnight on January 1, 1970). An incident is said to be "open" if the current time is between the trigger time and the resolve time. Our customers would like to query, for a given duration of time, the percentage of time in which there was at least one incident open.
Using your favourite programming language, you are tasked with writing a function that will answer this query. You may safely assume that all Unix time values fit within a 32-bit integer.
Here is what the signature of your function should look like in a few popular programming languages. Again, you may submit your solution using whatever programming language you like.

Example 1
query = (10, 20)
incidents = [(8, 15), (18, 19)]
assert percentage_time_at_least_one_incident(query, incidents) == 0.6



Example 2
query = (40, 70)
incidents = [(50, 60), (50, 62), (50, 65)]
assert percentage_time_at_least_one_incident(query, incidents) == 0.5




*/

import java.util.ArrayList;

public class PagerDuty {


	public  static void main(String args[]) {


	Pair query = new Pair(10, 20);

	ArrayList<Pair> incidents = new ArrayList<Pair>();
	incidents.add(new Pair(12,18));
	incidents.add(new Pair(13,17));

	double percent = percentTimeAtLeastOneIncident(query, incidents);
	System.out.println("percentage: "+ percent);
	}
	
	public static double percentTimeAtLeastOneIncident(Pair query, ArrayList<Pair> incidents ){

		double total;		
		if (incidents == null)
			return 0;
		
		// look for the first incident that falls into the query range
		int start = 0;

		while (incidents.get(start).getFirst()<query.getFirst() &&
		       incidents.get(start).getSecond()<query.getFirst() ) {
			start++;
		}

		System.out.println("start="+start);;
		if (start==incidents.size()) {
			return 0;
		}

		// start to accumulate from index "start"
		total = Math.min(incidents.get(start).getSecond(), query.getSecond())-
			Math.max(incidents.get(start).getFirst(), query.getFirst());

		// "end" signified the index of the first incident that falls outside of  query range
		int end= 0;

		for (int i=start+1; i< incidents.size(); i++) {
			if (incidents.get(i).getSecond()>query.getSecond()) {
				end = i;
				break;
			}

			// check if there is time overlap with previous incident
			if (incidents.get(i).getFirst()> incidents.get(i-1).getSecond())
				// no overlap
				total+= incidents.get(i).getLength();

			else {
				if (incidents.get(i).getSecond()> incidents.get(i-1).getSecond())			
			 		total+= (incidents.get(i).getSecond()-incidents.get(i-1).getSecond());
			}
			
		}

		// if we do find the first pair that falls outside of range
		if (end!=0)  {

			if (incidents.get(end).getFirst()> incidents.get(end-1).getSecond())
				total+=(query.getSecond()-incidents.get(end).getFirst());
			else
				total+=(query.getSecond()-incidents.get(end-1).getSecond());
		}
			
		System.out.println("total="+total);
		System.out.println("query length="+ query.getLength());
	
		return total/(double)query.getLength();
	}

}

class Pair {

	int first;
	int second;

	public Pair (int f, int s) {

		this.first = f;
		this.second= s;

	}


	public	int getFirst() {

		return this.first;
	}

	public int getSecond() {

		return this.second;
	}

	public int getLength() {
		return this.second - this.first;
	}	

}

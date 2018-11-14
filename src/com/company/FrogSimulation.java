package com.company;

public class FrogSimulation {

    private int goalDistance;
    private int maxHops;

    public FrogSimulation (int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
       double i = Math.random();
       if (i < .5)
       {
           int l = (int) Math.round((Math.random()*50));
           return l;
       }
       else
       {
           int p = (int) Math.round((Math.random()*50)*-1);
           return p;
       }
    }

    public boolean simulate() {
        int frogPosition = 0;
        int hopsRemaining = maxHops;

        while (frogPosition < goalDistance &&
                frogPosition >= 0 &&
                hopsRemaining > 0) {
            frogPosition += hopDistance();
            hopsRemaining--;
        }

        return frogPosition >= goalDistance;
    }

    public double runSimulations(int num) {
        int successfulRuns = 0;

        for (int run = 1; run <= num; run++)
            if (simulate())
                successfulRuns++;

        return successfulRuns / (double) num;
    }
}
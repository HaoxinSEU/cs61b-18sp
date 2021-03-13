public class NBody{
    /** Read the radius of the universe from the txt file. */
    public static double readRadius(String filePath){
        /* Start reading in the file. */
		In in = new In(filePath);

        int num = in.readInt();  // read the number of planets
        return in.readDouble();
    }

    /** Read all the planets in the file to an array. */
    public static Planet[] readPlanets(String filePath){
        /* Start reading in the file. */
		In in = new In(filePath);

        int num = in.readInt();  // read the number of planets
        double radius = in.readDouble();

        Planet[] allPlanets = new Planet[num];   //create the array of planets
        double xP;
        double xV;
        double yP;
        double yV;
        double m;
        String img;
        for (int i = 0 ; i < num ; i++){
            xP = in.readDouble();  //read the position in the x direction
            yP = in.readDouble();  //read the position in the y direction
            xV = in.readDouble();  //read the velocity in the x direction
            yV = in.readDouble();  //read the velocity in the y direction
            m = in.readDouble();  //read the mass of the planet
            img = in.readString();  //read the name of the image file
            
            allPlanets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return allPlanets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);  //store the 0th command line arguments
        double dt = Double.parseDouble(args[1]);  //store the 1st command line arguments
        String filename = args[2];  //store the 2nd command line argument as a String
        double radius = readRadius(filename);  //get the radius
        Planet[] allPlanets = readPlanets(filename);  //get all the planets
        
        String startImage = "images/starfield.jpg";

        /** Start the bgm. */
        StdAudio.play("audio/2001.mid");

        /** Sets up the universe so it goes from 
		  * -radius, -radius up to radius, radius */
		StdDraw.setScale(-radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();

        StdDraw.enableDoubleBuffering();

        double timeDuration = 0;
        double[] xForce = new double[allPlanets.length];
        double[] yForce = new double[allPlanets.length];
        while(timeDuration < T){
            /* Calculate the net force for every planet. */
            for (int i = 0 ; i < allPlanets.length ; i++){
                xForce[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForce[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }

            /* Update the current position for every planet. */
            for (int i = 0 ; i < allPlanets.length ; i++){
                allPlanets[i].update(dt, xForce[i], yForce[i]);
            }

            /*Draw the background and all planets. */
            StdDraw.picture(0, 0, startImage);

            for (Planet p : allPlanets){    
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            timeDuration += dt;
        }

        /** Print the universe when the simulation is over */
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allPlanets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName); 
        }

    }
}
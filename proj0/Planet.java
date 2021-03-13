public class Planet{
    private static final double G = 6.67e-11;  // gravtity constant
    public double xxPos;   //current x position
    public double yyPos;   //current y position
    public double xxVel;   //current velocity in the x direction
    public double yyVel;   //current velocity in the y direction
    public double mass;   //its mass
    public String imgFileName;   //the name corresponds to the image
    
    /** Creates a Planet instance with its variable. */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    /** Creates a identity Planet. */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Calculate the distance between two planets. */
    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /** Calculate the force exerted on this planet by the given planet. */
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        return ((G * mass * p.mass) / (r * r));
    }

    /** Calculate the force in the x direction */
    public double calcForceExertedByX(Planet p){
        double f = calcForceExertedBy(p);  //calculate the total force
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return ((f * dx) / r);
    }

    /** Calculate the force in the y direction */
    public double calcForceExertedByY(Planet p){
        double f = calcForceExertedBy(p);  //calculate the total force
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return ((f * dy) / r);
    }    

    /** Calculate the net force in the x direction */
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double fx = 0;
        for (Planet p : allPlanets){
            if (!equals(p)){
                fx = fx + calcForceExertedByX(p);
            }
        }
        return fx;
    }

    /** Calculate the net force in the y direction */
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double fy = 0;
        for (Planet p : allPlanets){
            if (!equals(p)){
                fy = fy + calcForceExertedByY(p);
            }
        }
        return fy;
    }

    /** Update the current position and velocity according to the force */
    public void update(double dt, double fX, double fY){
        double aX = fX / mass;   //acceleration in the x direction
        double aY = fY / mass;   //acceleration in the y direction

        xxVel = xxVel + dt * aX;  //update the velocity in the x direction
        yyVel = yyVel + dt * aY;  //update the velocity in the y direction

        xxPos = xxPos + dt * xxVel;  //update the position in the x direction
        yyPos = yyPos + dt * yyVel;  //update the position in the y direction 
    }

    /** Draw the current position of the planet. */
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }

}
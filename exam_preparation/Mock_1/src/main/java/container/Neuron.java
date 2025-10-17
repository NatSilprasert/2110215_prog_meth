package container;

public class Neuron {
    private static double minWeightValue;
    private static double maxWeightValue;
    private double[] weights;
    private double gradient;
    private double bias;
    private double value;

    public Neuron(double[] weights, double bias) {
        this.weights = weights;
        this.bias = bias;
        this.gradient = 0;
        this.value = 0;
    }

    public Neuron(double value) {
        this.value = value;
        this.gradient = -1;
        this.bias = -1;
        this.weights = null;
    }

    public static double getMinWeightValue() {
        return minWeightValue;
    }

    public static double getMaxWeightValue() {
        return maxWeightValue;
    }

    public double[] getWeights() {
        return weights;
    }

    public double getGradient() {
        return gradient;
    }

    public double getBias() {
        return bias;
    }

    public double getValue() {
        return value;
    }

    public static void setRangeWeight(double min, double max) {
        minWeightValue = min;
        maxWeightValue = max;
    }


    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public void setGradient(double gradient) {
        this.gradient = gradient;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

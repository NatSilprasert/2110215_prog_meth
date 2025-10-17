package container;

import function.Function;
import util.Activation;
import util.GenRandom;

public class Layer {
    Neuron[] neurons;
    Function function;

    public Layer(int inNeurons, int nNeurons, Function function) {
        this.neurons = new Neuron[nNeurons];
        for (int i = 0; i < nNeurons; i++) {
            double[] weights = new double[inNeurons];
            for (int j = 0; j < inNeurons; j++) {
                weights[j] = GenRandom.randomDouble(0, 1);
            }

            this.neurons[i] = new Neuron(weights, GenRandom.randomDouble(Neuron.getMinWeightValue(), Neuron.getMaxWeightValue()));
        }
        this.function = function;
    }

    public Layer(double[] input) {
        this.neurons = new Neuron[input.length];
        for (int i = 0; i < input.length; i++) {
            this.neurons[i] = new Neuron(input[i]);
        }
        function = null;
    }

    public double applyActivation(double x) {
        if (function == Function.SIGMOID) {
            return Activation.sigmoid(x);
        }
        else if (function == Function.TANH) {
            return Activation.tanh(x);
        }
        else if (function == Function.RELU) {
            return Activation.relu(x);
        }
        else {
            throw new IllegalArgumentException("Unknown activation function: " + function);
        }
    }

    public double applyActivationDerivative(double x) {
        if (function == Function.SIGMOID) {
            return Activation.sigmoidDerivative(x);
        }
        else if (function == Function.TANH) {
            return Activation.tanhDerivative(x);
        }
        else if (function == Function.RELU) {
            return Activation.reluDerivative(x);
        }
        else {
            throw new IllegalArgumentException("Unknown activation function: " + function);
        }
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}

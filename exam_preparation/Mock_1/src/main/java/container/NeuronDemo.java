package container;

public class NeuronDemo {
    private Neuron n;

    public void demonstrate() {
        n = new Neuron(new double[]{0.2, 0.3, 0.4}, 0.2);
        Neuron.setRangeWeight(0.1, 0.7);
        n.setGradient(0.6);
        n.setValue(1);
    }

    public Neuron getN() {
        return n;
    }

    public void setN(Neuron n) {
        this.n = n;
    }
}

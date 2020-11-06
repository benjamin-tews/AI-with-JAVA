
class Neuron {
    float weight1, weight2, weight3; //w1, w2, w3
    float bias = 1; //x0

    //constructor
    Neuron (float w1, float w2, float w3){
        weight1 = w1;
        weight2 = w2;
        weight3 = w3;
    }

    float getNeuron() {
        return weight1;
    }

    //modifies weights of neuron
    void modNeuron(int bias) {
        weight1 += bias;
    }

}

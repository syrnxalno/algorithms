/*
 * The Real and Complex form of DFT (Discrete Fourier Transforms) can be used to perform frequency analysis or synthesis for any discrete and periodic signals.
 * The FFT (Fast Fourier Transform) is an implementation of the DFT which may be performed quickly on modern CPUs.
 * The simplest and perhaps best-known method for computing the FFT is the Radix-2 Decimation in Time algorithm, attempted below
 */

/*
 * Some Standard constants
 * PI = 3.1415926535897932384626433832795 // PI for sine/cos calculations
 * TWOPI = 6.283185307179586476925286766559 // 2*PI for sine/cos calculations
 * Deg2Rad = 0.017453292519943295769236907684886 // Degrees to Radians factor
 * Rad2Deg = 57.295779513082320876798154814105 // Radians to Degrees factor
 * log10_2 = 0.30102999566398119521373889472449 // Log10 of 2
 * log10_2_INV = 3.3219280948873623478703194294948 // 1/Log10(2)
 */
public class Radix2FFT {
    public static void main(String args[]) {
        double log10_2_INV = 3.3219280948873623478703194294948;
        isPowerOfTwo(0, 0, log10_2_INV);
    }

    public static boolean isPowerOfTwo(int N, int M, double val) {
        M = (int) Math.ceil(Math.log10((double) N) * val);
        int NN = (int) Math.pow(2.0, M);

        if ((NN != N) || (NN == 0)) // Check N is a power of 2.
            return false;
        return true;
    }
}

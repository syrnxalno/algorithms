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
 *  */
   public class Radix2FFT {

    // constants
    public static final double PI = 3.1415926535897932384626433832795;
    public static final double TWOPI = 6.283185307179586476925286766559;
    public static final double log10_2 = 0.30102999566398119521373889472449;
    public static final double log10_2_INV = 3.3219280948873623478703194294948;

    // Complex number class
    public static class Complex {
        public double re;
        public double im;

        public Complex() {
            this.re = 0.0;
            this.im = 0.0;
        }

        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        // complex multiplication
        // todo: Consider making this an instance method (a.multiply(b)) to avoid always creating new objects.
        public static Complex multiply(Complex a, Complex b) {
            return new Complex(a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re);
        }
    }

    // Check if N is a power of 2
    public static boolean isPowerOfTwo(int N, int[] M) {
        M[0] = (int) Math.ceil(Math.log10(N) * log10_2_INV);
        int NN = (int) Math.pow(2, M[0]);
        return NN == N && NN != 0;
    }

    // Radix-2 FFT
    public static void rad2FFT(int N, Complex[] x, Complex[] DFT) throws Exception {
        int[] M = new int[1];
        if (!isPowerOfTwo(N, M)) {
            throw new Exception("Rad2FFT(): N must be a power of 2 for Radix FFT");
        }

        int stages = M[0];
        int MM1 = stages - 1;
        double twoPi_N = TWOPI / N;

        // bit reversal
        for (int i = 0; i < N; i++) {
            int ii = 0;
            int iaddr = i;
            for (int l = 0; l < stages; l++) {
                if ((iaddr & 0x01) != 0) {
                    ii += 1 << (MM1 - l);
                }
                iaddr >>= 1;
                if (iaddr == 0) break;
            }
            DFT[ii] = new Complex(x[i].re, x[i].im);
        }

        // FFT computation (butterfly)
        for (int stage = 1; stage <= stages; stage++) {
            int BSep = (int) Math.pow(2, stage);
            int BWidth = BSep / 2;
            int P = N / BSep;
            double twoPi_NP = twoPi_N * P;

            for (int j = 0; j < BWidth; j++) {
                Complex WN = new Complex(1.0, 0.0);
                if (j != 0) {
                    WN.re = Math.cos(twoPi_NP * j);
                    WN.im = -Math.sin(twoPi_NP * j);
                }

                for (int HiIndex = j; HiIndex < N; HiIndex += BSep) {
                    Complex pHi = DFT[HiIndex];
                    Complex pLo = DFT[HiIndex + BWidth];

                    if (j != 0) {
                        Complex TEMP = Complex.multiply(pLo, WN);
                        pLo.re = TEMP.re;
                        pLo.im = TEMP.im;
                    }
                    // todo: could optimize by doing in-place addition or subtraction?
                    DFT[HiIndex + BWidth].re = pHi.re - pLo.re;
                    DFT[HiIndex + BWidth].im = pHi.im - pLo.im;
                    DFT[HiIndex].re = pHi.re + pLo.re;
                    DFT[HiIndex].im = pHi.im + pLo.im;
                }
            }
        }
    }

    // Test method
    public static void main(String[] args) {
        try {
            int N = 8; // Must be a power of 2
            Complex[] x = new Complex[N];
            Complex[] DFT = new Complex[N];

            for (int i = 0; i < N; i++) {
                x[i] = new Complex(i + 1, 0); // Example input
                DFT[i] = new Complex();
            }

            rad2FFT(N, x, DFT);

            System.out.println("FFT Result:");
            for (Complex c : DFT) {
                System.out.printf("%.4f + %.4fi%n", c.re, c.im);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

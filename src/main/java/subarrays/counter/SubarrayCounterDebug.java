package subarrays.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayCounterDebug {

    // ANSI Colors (funcionam no IntelliJ)
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    // Método simples para logs indentados
    private static void logIndented(String msg, int level) {
        System.out.println("    ".repeat(level) + msg);
    }

    // Visualização gráfica ASCII do prefix sum
    private static void printVisualPrefixState(int index, long prefix, long needed, long freq) {

        System.out.println("\n" + CYAN + "   GRAPH VIEW" + RESET);
        logIndented("Index: " + index, 1);

        int barLength = (int) (Math.abs(prefix) % 40);
        String bar = "|".repeat(Math.max(1, barLength));

        logIndented("Prefix [" + prefix + "]: " + bar, 1);

        if (freq > 0) {
            logIndented(GREEN + "MATCH: prefix - k = " + needed +
                    " (freq=" + freq + ")" + RESET, 2);
            logIndented(GREEN + "[ FOUND SUBARRAY ]" + RESET, 3);
        } else {
            logIndented(RED + "No match for needed prefix = " + needed + RESET, 2);
        }
    }

    // Função principal solicitada
    public static long countSubarraysWithSumAndMaxAtMost(List<Integer> nums, long k, long M) {

        System.out.println(BOLD + BLUE + "\n===== STARTING MAIN ALGORITHM =====" + RESET);

        long totalCount = 0;
        int n = nums.size();
        int start = 0;

        while (start < n) {

            // Ignorar elementos > M
            if (nums.get(start) > M) {
                System.out.println(RED + "Skipping index " + start +
                        " (value=" + nums.get(start) + " > M)" + RESET);
                start++;
                continue;
            }

            // Encontrar o próximo segmento válido
            int end = start;
            while (end < n && nums.get(end) <= M) {
                end++;
            }

            System.out.println(BOLD + CYAN + "\nFound valid segment: [" + start + ", " + end + "]" + RESET);

            totalCount += countSubarraysWithSum(nums, start, end, k);

            start = end;
        }

        System.out.println(BOLD + GREEN + "\nTOTAL SUBARRAYS FOUND = " + totalCount + RESET);
        System.out.println(BOLD + BLUE + "===== END =====\n" + RESET);

        return totalCount;
    }

    // Contagem de subarrays com soma exata = k em um segmento
    private static long countSubarraysWithSum(List<Integer> nums, int start, int end, long k) {

        System.out.println(BOLD + BLUE + "\n========== NEW SEGMENT ==========" + RESET);
        System.out.println(CYAN + "Segment indices: [" + start + ", " + end + ")" + RESET);

        System.out.print(CYAN + "Values: " + RESET + "[");
        for (int i = start; i < end; i++)
            System.out.print(nums.get(i) + (i < end - 1 ? ", " : "]\n"));

        Map<Long, Long> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1L);

        long prefix = 0;
        long count = 0;

        System.out.println(YELLOW + "Initial prefixCount = {0=1}\n" + RESET);

        // Loop principal sobre o segmento
        for (int i = start; i < end; i++) {

            int value = nums.get(i);
            prefix += value;

            logIndented(BLUE + "--> i = " + i + RESET, 0);
            logIndented("Value = " + value, 1);
            logIndented("Prefix sum = " + prefix, 1);

            long needed = prefix - k;
            long freq = prefixCount.getOrDefault(needed, 0L);

            logIndented("Looking for prefix = prefix - k = " + needed, 1);
            logIndented("Frequency found = " + freq, 1);

            // Exibir visualização gráfica
            printVisualPrefixState(i, prefix, needed, freq);

            // Contabilizar subarrays encontrados
            if (freq > 0) {
                logIndented(GREEN + "FOUND " + freq + " subarray(s) ending at " + i + RESET, 2);
            }

            count += freq;

            // Atualizar mapa de prefixos
            long newFreq = prefixCount.getOrDefault(prefix, 0L) + 1;
            prefixCount.put(prefix, newFreq);

            logIndented(YELLOW + "prefixCount[" + prefix + "] = " + newFreq + RESET, 2);
            System.out.println();
        }

        System.out.println(GREEN + "Segment total = " + count + RESET);
        System.out.println(BOLD + BLUE + "================================\n" + RESET);

        return count;
    }
}


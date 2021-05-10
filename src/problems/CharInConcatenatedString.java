package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CharInConcatenatedString {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter wr = new PrintWriter(System.out);

		int N = Integer.parseInt(br.readLine().trim());

		String[] str = new String[N];

		for (int i_str = 0; i_str < N; i_str++)

		{

			str[i_str] = br.readLine();

		}

		int Q = Integer.parseInt(br.readLine().trim());

		int[][] query = new int[Q][3];

		for (int i_query = 0; i_query < Q; i_query++)

		{

			String[] arr_query = br.readLine().split(" ");

			for (int j_query = 0; j_query < arr_query.length; j_query++)

			{

				query[i_query][j_query] = Integer.parseInt(arr_query[j_query]);

			}

		}

		char[] out_ = char_at_K(N, str, Q, query);

		System.out.print(out_[0]);

		for (int i_out_ = 1; i_out_ < out_.length; i_out_++)

		{

			System.out.print("\n" + out_[i_out_]);

		}

		wr.close();

		br.close();

	}
	
	static char[] char_at_K(int N, String[] str, int Q, int[][] query) {

		// Write your code here

		char[] chars = new char[Q];

		for (int j = 0; j < Q; j++) {

			StringBuffer result = new StringBuffer();

			for (int i = query[j][0] - 1; i < query[j][1]; i++) {

				if (i < N)

					result.append(str[i]);

			}

			char[] resultArr = result.toString().toCharArray();

			Arrays.sort(resultArr);

			chars[j] = resultArr[query[j][2] - 1];

		}

		return chars;

	}

}
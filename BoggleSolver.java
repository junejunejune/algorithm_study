import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.TrieSET;
class BoggleBoard {
    // the 16 Boggle dice (1992 version)
    private static final String[] BOGGLE_1992 = {
        "LRYTTE", "VTHRWE", "EGHWNE", "SEOTIS",
        "ANAEEG", "IDSYTT", "OATTOW", "MTOICU",
        "AFPKFS", "XLDERI", "HCPOAS", "ENSIEU",
        "YLDEVR", "ZNRNHL", "NMIQHU", "OBBAOJ"
    };
    // the 16 Boggle dice (1983 version)
    private static final String[] BOGGLE_1983 = {
        "AACIOT", "ABILTY", "ABJMOQ", "ACDEMP",
        "ACELRS", "ADENVZ", "AHMORS", "BIFORX",
        "DENOSW", "DKNOTU", "EEFHIY", "EGINTV",
        "EGKLUY", "EHINPS", "ELPSTU", "GILRUW",
    };
    // the 25 Boggle Master / Boggle Deluxe dice
    private static final String[] BOGGLE_MASTER = {
        "AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM",
        "AEEGMU", "AEGMNN", "AFIRSY", "BJKQXZ", "CCNSTW",
        "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DHHLOR",
        "DHHNOT", "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU",
        "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"
    };
    // the 25 Big Boggle dice
    private static final String[] BOGGLE_BIG = {
        "AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM",
        "AEEGMU", "AEGMNN", "AFIRSY", "BJKQXZ", "CCENST",
        "CEIILT", "CEILPT", "CEIPST", "DDHNOT", "DHHLOR",
        "DHLNOR", "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU",
        "FIPRSY", "GORRVW", "IPRRRY", "NOOTUW", "OOOTTU"
    };
    // letters and frequencies of letters in the English alphabet
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final double[] FREQUENCIES = {
        0.08167, 0.01492, 0.02782, 0.04253, 0.12703, 0.02228,
        0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025,
        0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987,
        0.06327, 0.09056, 0.02758, 0.00978, 0.02360, 0.00150,
        0.01974, 0.00074
    };

    private final int m;        // number of rows
    private final int n;        // number of columns
    private char[][] board;     // the m-by-n array of characters
    public BoggleBoard() {
        m = 4;
        n = 4;
        StdRandom.shuffle(BOGGLE_1992);
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String letters = BOGGLE_1992[n*i+j];
                int r = StdRandom.uniform(letters.length());
                board[i][j] = letters.charAt(r);
            }
        }
    }
    public BoggleBoard(String filename) {
        In in = new In(filename);
        m = in.readInt();
        n = in.readInt();
        if (m <= 0) throw new IllegalArgumentException("number of rows must be a positive integer");
        if (n <= 0) throw new IllegalArgumentException("number of columns must be a positive integer");
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String letter = in.readString().toUpperCase();
                if (letter.equals("QU"))
                    board[i][j] = 'Q';
                else if (letter.length() != 1)
                    throw new IllegalArgumentException("invalid character: " + letter);
                else if (ALPHABET.indexOf(letter) == -1)
                    throw new IllegalArgumentException("invalid character: " + letter);
                else 
                    board[i][j] = letter.charAt(0);
            }
        }
    }
    public BoggleBoard(int m, int n) {
        this.m = m;
        this.n = n;
        if (m <= 0) throw new IllegalArgumentException("number of rows must be a positive integer");
        if (n <= 0) throw new IllegalArgumentException("number of columns must be a positive integer");
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = StdRandom.discrete(FREQUENCIES);
                board[i][j] = ALPHABET.charAt(r);
            }
        }
    }
    public BoggleBoard(char[][] a) {
        this.m = a.length;
        this.n = a[0].length;
        if (m <= 0) throw new IllegalArgumentException("number of rows must be a positive integer");
        if (n <= 0) throw new IllegalArgumentException("number of columns must be a positive integer");
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            if (a[i].length != n)
                throw new IllegalArgumentException("char[][] array is ragged");
            for (int j = 0; j < n; j++) {
                if (ALPHABET.indexOf(a[i][j]) == -1)
                    throw new IllegalArgumentException("invalid character: " + a[i][j]);
                board[i][j] = a[i][j];
            }
        }
    }
    public int rows() 
    {    return m; }

    public int cols() 
    {   return n; }

    public char getLetter(int i, int j) {
        return board[i][j];
    }
    public String toString() {
        StringBuilder sb = new StringBuilder(m + " " + n + "\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
                if (board[i][j] == 'Q') sb.append("u ");
                else sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}



public class BoggleSolver 
{
    private TrieSET dictionary;
	// Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary)
    {
    		this.dictionary = new TrieSET();
        for (String s : dictionary) 
        {
             this.dictionary.add(s);
        }
    }
    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {

    		SET<String> validWords = new SET<String>();
    		for	(int i = 0; i < board.rows(); i++)
    		{
    			for	(int j = 0; j < board.cols(); j++)
    			{
    	    			boolean[][] visited = new boolean[board.rows()][board.cols()];
    	    			//System.out.println("i: "+i+"j: "+j);
    				solve_DFS(board,visited,i,j,"",validWords);
    			}
    		}
    		return validWords;
    }
    private void solve_DFS(BoggleBoard board, boolean[][] visited, int a, int b, String str, SET<String> validWords)
    {
    //	System.out.println("a: "+a+"b: "+b);
    		if(visited[a][b])
    			return;
    		else
    			visited[a][b] = true;
    		
    		char temp = board.getLetter(a, b);
    		//System.out.println(temp);
    		if (temp == 'Q')
    			str += "QU";
    		else
    			str += temp;
    		//System.out.println(str);
    		
    		if(dictionary.keysWithPrefix(str)==null)
    			return;
    		if(dictionary.contains(str) && str.length() > 2)
    			validWords.add(str);
    		
    		//check surrounding characters
    		for (int row = a-1; row <= a+1 && row < board.rows(); row++)
    		{
    			for (int col = b-1; col <= b+1 && col<board.cols(); col++)
    			{
    				if(row>=0 && col>=0)
    					solve_DFS(board, visited, row, col, str, validWords);
    			}
    		}
    		visited[a][b] = false;
    }
    
    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word)
    {
    		if(dictionary.contains(word))
    		{
    			if(word.length()==0||word.length()==1||word.length()==2)
    				return 0;
    			else if(word.length()==3 ||word.length()==4)
    				return 1;
    			else if(word.length()==5)
    				return 2;
    			else if(word.length()==6)
    				return 3;
    			else if(word.length()==7)
    				return 5;
    			else
    				return 11;
    		}
    		else
    			return 0;
    }
    public static void main(String[] args) 
    {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        int score = 0;
        for (String word : solver.getAllValidWords(board)) 
        {
            StdOut.println(word);
            score += solver.scoreOf(word);
            //System.out.println(solver.scoreOf(word));
        }
        StdOut.println("Score = " + score);
    }
}


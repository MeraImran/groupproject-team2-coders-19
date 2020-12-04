package starter;


	public class Pos {
		private int row;
		private int col;
		
		public Pos(int x, int y) {
			setRow(x);
			setCol(y);
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}
	}



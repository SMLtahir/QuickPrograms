package miscellaneous;

public class ImplementedHashMap {
	private static final int SIZE = 16;
	Entry[] table = new Entry[SIZE];
	
	class Entry {
		String key;
		String value;
		Entry next;
		
		Entry(String k, String v) {
			this.key = k;
			this.value = v;
		}
		
		public String getKey() {
			return key;
		}
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String v) {
			this.value = v;
		}
	}
	
	public Entry get(String key) {
		int hash = key.hashCode() % SIZE;
		Entry e = table[hash];
		
		while(e != null) {
			if(e.key.equals(key)) {
				return e;
			}
			e = e.next;
		}
		return null;
	}
	
	public void put(String k, String v) {
		int hash = k.hashCode() % SIZE;
		Entry e = table[hash];
		if(e != null) {
			if(e.key.equals(k)) {
				e.setValue(v);
			}
			while(e.next != null) {
				e = e.next;
			}
			Entry newE = new Entry(k, v);
			e.next = newE;
		} else {
			Entry newE = new Entry(k, v);
			table[hash] = newE;
		}
	}
}

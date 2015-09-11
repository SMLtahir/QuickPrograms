package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Design a musical juke box using object oriented principles
 * 
 * I have designed this entirely by myself without any reference.
 * Please refer to other material to verify the presence of all required info.
 * This is also implemented in Cracking The Coding Interview for example.
 * @author Tahir
 *
 */
public class MusicJukebox {
	// Normally using a set for allMusic would be better as you can then have only unique songs in the jukebox
	// However, it seems to be more difficult (high time complexity) to implement shuffle using set 
	List<Song> allMusic;
	boolean shuffle;
	Set<Playlist> playlists;
	Queue<Song> q;
	
	public MusicJukebox() {
		this.shuffle = false;
		playlists = new HashSet<Playlist>();
		allMusic = new ArrayList<Song>();
		q = new LinkedList<Song>();
	}
	
	public void addSong(Song song) {
		allMusic.add(song);
	}
	
	public boolean removeSong(Song song) {
		if(allMusic.contains(song)) { return allMusic.remove(song);}
		return false;		
	}
	
	public boolean addPlaylist(Playlist pl) {
		return playlists.add(pl);
	}
	
	public boolean removePlaylist(Playlist pl) {
		return playlists.remove(pl);
	}
	
	public void addSongToQueue(Song song) {
		q.add(song);
	}
	
	public void play() {
		int songId = 0;
		while(!q.isEmpty()) {
			if(shuffle) { 
				songId = (int) Math.random()*(allMusic.size());
				System.out.println( playSong(allMusic.get(songId)) );
				q.remove(allMusic.get(songId));
				continue;
			}
			System.out.println( playSong(q.remove()) );
		}
	}
	
	public String playSong(Song song) {
		int id = allMusic.indexOf(song);
		if(id != -1) { 
			// Play song
			return song.toString();
		}
		return "Sorry, this song cannot be found.";
	}
	
	public void playFromPlaylist(Playlist pl) {
		List<Song> listSongs = pl.getSongs();
		int songId = 0;
		while(true) { // This should be made to continue until interrupted by an external process
			if(shuffle) { songId = (int) Math.random()*(listSongs.size());}
			System.out.println( playSong(listSongs.get(songId)) );
			songId++;
		}
	}
	
	public void setShuffle(boolean shuffle) {
		this.shuffle = shuffle;
	}
}

class Song {
	String name;
	String album;
	String artist;
	double duration;
	
	public Song(String name, String album, String artist, double duration) {
		this.name = name;
		this.album = album;
		this.artist = artist;
		this.duration = duration;
	}
	
	public String toString() {
		return " Name: "+ this.name+ " Album: "+ this.album+ " Artist: "+ this.artist+ " Duration: "+ this.duration;
	}
}

class Playlist {
	Set<Song> songs;
	String name;
	
	public Playlist(Set<Song> songs, String name) {
		this.songs = songs;
		this.name = name;
	}
	
	public boolean addSong(Song song) {
		return songs.add(song);
	}
	
	public boolean removeSong(Song song) {
		if(songs.contains(song)) { return songs.remove(song);}
		return false;
	}
	
	public List<Song> getSongs() {
		List<Song> list = new ArrayList<Song>();
		list.addAll(songs);
		return list;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Playlist name: "+ this.name + "\n");
		for(Song song : this.songs) {
			sb.append(song.toString() + "\n");
		}
		return sb.toString();
	}
}
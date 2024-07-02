package com.data_structure.linear.hash_tables;

import java.util.LinkedList;

public class HashTable {

  private LinkedList<Entry>[] entries = new LinkedList[5];

  public void put(int key, String value) {
    var entry = getEntry(key);
    if (entry != null) {
      entry.value = value;
      return;
    }

    var bucket = getOrCreateBucket(key);
    bucket.addLast(new Entry(key, value));
  }

  public String get(int key) {
    var entry = getEntry(key);
    return (entry == null) ? null : entry.value;
  }

  public void remove(int key) {
    var entry = getEntry(key);
    if (entries == null) {
      throw new IllegalStateException();
    }
    var bucket = getBucket(key);
    bucket.remove(entry);
  }

  private int hash(int key) {
    return key % entries.length;
  }

  private LinkedList<Entry> getBucket(int key) {
    return entries[hash(key)];
  }

  private LinkedList<Entry> getOrCreateBucket(int key) {
    var index = hash(key);
    var bucket = entries[index];
    if (bucket == null) {
      bucket = new LinkedList<>();
      entries[index] = bucket;
    }
    return bucket;
  }

  private Entry getEntry(int key) {
    var bucket = getBucket(key);
    if (bucket != null) {
      for (var entry : bucket) {
        if (entry.key == key) {
          return entry;
        }
      }
    }
    return null;
  }

  private class Entry {

    private int key;
    private String value;

    public Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }
}


/*
 * Métodos para resolver colisões em hash tables
 *
 *
 * "PROBING"
 *
 * LINEAR
 * (hash1 + i) % table_size
 *
 * QUADRATIC
 * (hash1 + i²) % table_size
 *
 * DOUBLE HASH
 * (hash1 + i * hash2) % table_size
 * */
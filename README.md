## File Packer & Unpacker (Java)

A simple yet effective file management utility built in Java that packs multiple text files into a single file and unpacks them back to their original form. The project also includes a basic encryption mechanism to secure file data.

## Overview

This project demonstrates how multiple files can be combined into a single packed file using custom metadata (headers). Each file is encrypted before packing and decrypted during unpacking, ensuring basic data security.

It is a console-based application focused on understanding file handling, data processing, and low-level system concepts.

## Tech Stack
Language: Java
Concepts Used:
File Handling
Byte Streams
Encryption (XOR)
Data Parsing

## Features
Packs multiple .txt files into one file
Applies XOR-based encryption while packing
Extracts files back with decryption
Uses custom file headers (filename + size)
Lightweight and fast execution

## How It Works
  1) Packing Process
Reads all .txt files from a folder
Creates a header containing file name and size
Encrypts file data using XOR operation
Stores header + encrypted data into a single packed file

 2) Unpacking Process
Reads header from packed file
Extracts file metadata (name & size)
Decrypts data using XOR
Recreates original files

Getting Started
# Compile
javac Packer.java Unpacker.java

# Run Packer
java Packer

# Run Unpacker
java Unpacker

## Future Improvements
Support for multiple file formats (PDF, images, etc.)
Compression to reduce file size
GUI-based interface
Stronger encryption (AES)

## Learning Outcomes
Deep understanding of Java file handling
Working with byte streams and buffers
Designing custom file formats
Basics of encryption & decryption logic

## Contributing

Contributions are welcome. Feel free to fork the repo and improve the functionality.

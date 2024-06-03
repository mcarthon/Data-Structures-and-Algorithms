use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;
use regex::Regex;

fn main() -> io::Result<()> {
    let path = Path::new(".\\src\\text.txt");
    let file = File::open(&path)?;
    let reader = io::BufReader::new(file);
    let mut sum: i32 = 0;

    for line in reader.lines() {
        sum += extract_int(&line?);
    }
    println!("{}", sum);
    Ok(())
}

fn extract_int ( line: &str ) -> i32 {
    let re_pattern = Regex::new(r"^([^0-9]*)([0-9])(.*?)([0-9]?)([^0-9]*)$")
        .expect("\nRegular expression failed.\n");
    if let Some(groups) = re_pattern.captures(line) {
        let mut num_text: String = format!("{}{}", groups[2].to_string(), groups[4].to_string());
        if num_text.len() < 2 {
            num_text = format!("{}{}", num_text, num_text);
        }
        let int_value: i32 = num_text.parse()
            .expect("\nFailed to parse the string to an i32.\n");
        return int_value;
    }
    -2147483648
}
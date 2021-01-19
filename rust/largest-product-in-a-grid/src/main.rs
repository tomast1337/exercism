fn main() {
    use std::time::SystemTime;
    let gridfile = std::fs::read_to_string("./grid.txt").expect("Erro ao abrir series.txt");
    println!("\n\n\n\t\t\tGrid\n\n{}", gridfile);
    let time = SystemTime::now();
    println!("\nO maior produto de 4 valores vizinhos nas verticas horizoltais e diagonais na grade é:{}",largest_grid_product(gridfile,4));
    let elapsed = time.elapsed().unwrap();
    println!("\n\tTempo de execução:{:?}\n\n\n\n\n", elapsed);
}

fn largest_grid_product(grid: String, length: i64) -> i64 {
    let grid_rows: Vec<&str> = grid.split("\n").collect();
    let mut grid_vec: Vec<Vec<i64>> = Vec::new();

    for row in grid_rows {
        let mut row_vec: Vec<i64> = Vec::new();
        for element in row.split_whitespace() {
            row_vec.push(element.parse::<i64>().unwrap());
        }
        grid_vec.push(row_vec)
    }

    if length > grid_vec.len() as i64 {
        return 0;
    }

    let product1: i64 = largest_horizontal_product(&grid_vec, length);
    let product2: i64 = largest_vertical_product(&grid_vec, length);
    let product3: i64 = largest_diagonal_product(&grid_vec, length);
    println!("\n\tMaior produto horizontal: {}\n\tMaior produto vertical: {}\n\tMaior produto diagonal: {}",product1,product2,product3);

    if product1 > product2 && product1 > product3 {
        return product1;
    }
    if product2 > product1 && product2 > product3 {
        return product2;
    } else {
        return product3;
    }
}

fn largest_horizontal_product(grid: &Vec<Vec<i64>>, length: i64) -> i64 {
    let mut biggest_product = 0;
    let mut biggest_elements: Vec<i64> = Vec::new();

    for row in grid {
        for start_element_index in 0..(row.len() as i64 - length + 1) {
            let mut product: i64 = 1;
            let mut elements: Vec<i64> = Vec::new();

            for i in start_element_index..length + start_element_index {
                product = product * row[i as usize];
                elements.push(row[i as usize]);
            }
            if product > biggest_product {
                biggest_product = product;
                biggest_elements = elements;
            }
        }
    }

    println!(
        "\nElementos do maior porduto horizontal: {:?} ",
        biggest_elements
    );
    biggest_product
}

fn largest_vertical_product(grid: &Vec<Vec<i64>>, length: i64) -> i64 {
    let mut biggest_product = 0;
    let mut biggest_elements: Vec<i64> = Vec::new();

    for collum in 0..(grid.len() as i64) {
        for start_row_index in 0..(grid.len() as i64 - length + 1) {
            let mut product: i64 = 1;
            let mut elements: Vec<i64> = Vec::new();

            for i in start_row_index..length + start_row_index {
                product = product * grid[i as usize][collum as usize];
                elements.push(grid[i as usize][collum as usize]);
            }
            if product > biggest_product {
                biggest_product = product;
                biggest_elements = elements;
            }
        }
    }

    println!(
        "\nElementos do maior porduto vertical: {:?} ",
        biggest_elements
    );
    biggest_product
}

fn largest_diagonal_product(grid: &Vec<Vec<i64>>, length: i64) -> i64 {
    let mut biggest_product = 0;
    let mut biggest_elements: Vec<i64> = Vec::new();

    for start_collum_index in 0..(grid.len() as i64 - length + 1) {
        for start_row_index in 0..(grid.len() as i64 - length + 1) {
            let mut diagonal1_product: i64 = 1;
            let mut diagonal2_product: i64 = 1;

            let mut diagonal1_elements: Vec<i64> = Vec::new();
            let mut diagonal2_elements: Vec<i64> = Vec::new();

            for index in 0..length {
                let (i, j) = (
                    (start_collum_index + index) as usize,
                    (start_row_index + index) as usize,
                );
                diagonal1_product = diagonal1_product * grid[j][i];
                diagonal1_elements.push(grid[j][i]);

                let (c, r) = (
                    (start_collum_index + length - index - 1) as usize,
                    (start_row_index + index) as usize,
                );
                diagonal2_product = diagonal2_product * grid[r][c];
                diagonal2_elements.push(grid[r][c])
            }
            if diagonal1_product > diagonal2_product {
                if diagonal1_product > biggest_product {
                    biggest_product = diagonal1_product;
                    biggest_elements = diagonal1_elements;
                }
            } else {
                if diagonal2_product > biggest_product {
                    biggest_product = diagonal2_product;
                    biggest_elements = diagonal2_elements;
                }
            }
        }
    }

    println!(
        "\nElementos do maior porduto diagonal: {:?} ",
        biggest_elements
    );
    biggest_product
}

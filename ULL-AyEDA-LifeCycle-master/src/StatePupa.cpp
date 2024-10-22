/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Algoritmos y Estructuras de Datos Avanzados
 * @file: P02DiegoDiazMoron/StatePupa
 * @author: Diego Diaz Moron
 * @mail: alu0101337975@ull.edu.es
 * @date: 13/03/22
 * @brief: Ciclo de la Vida
 */

#include "Grid.hpp"
#include "State.hpp"

StatePupa::StatePupa() : State() {}

StatePupa::~StatePupa() {}

char StatePupa::GetState() const { return 'P'; }

void StatePupa::Neighbors(const Grid& world, int i, int j) {
  Neighbords neighbords_ = world.GetCell(i, j).GetCellNeighbords();
  nextstate_ = neighbords_.larva > (neighbords_.egg + neighbords_.pupa +
                                    neighbords_.adult + neighbords_.dead)
                   ? 0
                   : 1;
}

State* StatePupa::NextState() {
  State* output;
  if (nextstate_ == true)
    output = new StateAdult();
  else
    output = new StateDead();
  return output;
}
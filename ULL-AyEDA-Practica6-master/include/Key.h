//
// Created by diedi on 03/05/2022.
//

#ifndef P06DIEGODIAZMORON_INCLUDE_KEY_H_
#define P06DIEGODIAZMORON_INCLUDE_KEY_H_

template <typename T>
class Key {
 public:
  Key(T key) : key_(key) {}
  ~Key() = default;
  T getKey() const { return key_; }
 private:
  T key_;
};
#endif //P06DIEGODIAZMORON_INCLUDE_KEY_H_

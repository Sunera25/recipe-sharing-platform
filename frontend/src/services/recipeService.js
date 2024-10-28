import axios from "axios";

export const fetchCategories = async () => {
  try {
    const response = await axios.get("");
    return response.data;
  } catch (error) {
    console.error("Error Fetching Categories: ", error);
  }
};
